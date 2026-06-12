package com.example.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.ex03_embeddable.Address;
import com.example.jpa.ex03_embeddable.Company;
import com.example.jpa.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SpringBootTest
class Ex03EmbbedableTests {

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
	@DisplayName("임베디드 타입 테스트")
	void embbededTest() {
		Address office = new Address("Seoul", "문래대로", "12345");

		Address factory = new Address("Seoul", "디지털로", "54321");

		Company company = new Company(1L, "새싹소프트", office, factory);

		em.persist(company); // 영속성 상태가 됨 - insert 쿼리 쌓임

		em.flush(); // 쿼리 날림

		Company findCompany = em.find(Company.class, 1L); // 1차 캐시에서 발견하므로 db까지 안감

		assertEquals("새싹소프트", findCompany.getName());

	}

}