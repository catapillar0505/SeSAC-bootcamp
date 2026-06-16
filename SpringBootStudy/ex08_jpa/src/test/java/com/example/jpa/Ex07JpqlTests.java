package com.example.jpa;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.ex07_jpql.Department;
import com.example.jpa.ex07_jpql.Employee;
import com.example.jpa.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@SpringBootTest
class Ex07JpqlTests {

  // 엔티티 매니저 (영속성 컨텍스트 관리자)
  private EntityManager em;

  // 엔티티 트랜잭션
  private EntityTransaction tx;

  // 테스트 시작 전 엔티티 매니저를 만들기 위해 팩토리(공장)부터 지어둠
  @BeforeAll
  static void setUpBeforeClass() {
    JpaUtil.initFactory();
  }

  // 각 테스트 시작 전 엔티티 매니저를 생성
  @BeforeEach
  void setUp() {
    em = JpaUtil.getEntityManager();
    tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 내부에서 실행되어야 함
    tx.begin();
  }

  // 각 테스트 종료 후 엔티티 메니저를 닫아줌
  @AfterEach
  void tearDown() {
    if (tx != null && tx.isActive()) {
      tx.rollback();
    }
    if (em != null && em.isOpen()) {
      em.close();
    }
  }

  // 전체 테스트 종료 후 엔티티 매니저 팩토리를 닫아줌
  @AfterAll
  static void tearDownAfterClass() {
    JpaUtil.closeFactory();
  }

  // 이제부터 테스트 진행
  @Test
  @DisplayName("반환타입이 query인 jpql")
  void queryTest() {
    // 부서 및 사원 등록
    Department dept = new Department("Develop");
    Employee emp1 = new Employee("doran", 5000);
    Employee emp2 = new Employee("faker", 100000);
    
    // 부서를 통해 사원을 알고,사원을 통해 부서를 알도록 비즈니스 메서드 작성
    dept.registerEmployee(emp1, dept);
    dept.registerEmployee(emp2, dept);
    
    // 영속화
    em.persist(dept);
    em.persist(emp1);
    em.persist(emp2);

    // 쓰기 지연 sql 저장소의 쿼리를 db로 날림
    //em.flush();

    Query query = em.createQuery("select e.name, e.salary from Employee e");
    List<Object[]> results = query.getResultList(); // object[] => {"kim",6000}, {"lee",3000}
    results.stream().forEach(obj -> {
      Object[] row = (Object[]) obj;
      System.out.println("이름: "+ row[0] + "급여: " + row[1]);

    });

  }

  @Test
  @DisplayName("반환타입이 TypedQuery인 jpql")
  void typedQueryTest() {
    TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);

    List<Employee> employees = query.getResultList();
    employees.stream().forEach(emp -> System.out.println("name: "+emp.getName()));
  }

  @Test
  @DisplayName("N+1문제 jpql")
  void nPulsOneTest() {
    Department dept = new Department("Develop");
    Employee emp1 = new Employee("doran", 5000);
    Employee emp2 = new Employee("faker", 100000);
    
    // 부서를 통해 사원을 알고,사원을 통해 부서를 알도록 비즈니스 메서드 작성
    dept.registerEmployee(emp1, dept);
    dept.registerEmployee(emp2, dept);
    
    // 영속화
    em.persist(dept);
    em.persist(emp1);
    em.persist(emp2);

    // db로부터 조회하기위해 영속화된 엔티티를 준영속 상태로 변경
    em.clear();

    // 사원 2명 조회하는 쿼리인데, 쿼리는 3번 날아감
    // 사원 조회 쿼리 작성
    TypedQuery<Employee> query = em.createQuery("select e from Employee e join fetch e.department", Employee.class);
    List<Employee> employees = query.getResultList();

    // 사원마다 부서를 조회하는 쿼리 (n명)
    for (Employee emp : employees) {
      System.out.println("Department Name: " + emp.getDepartment().getDeptName());
    }

  }

}