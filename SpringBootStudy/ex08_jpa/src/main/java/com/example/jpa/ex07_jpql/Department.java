package com.example.jpa.ex07_jpql;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 부모 엔티티

@Entity
@Table(name = "departments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String deptName;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees = new ArrayList<>();

  public Department(String deptName) {
    this.deptName = deptName;
  }

  public void registerEmployee(Employee emp, Department dept){
    this.getEmployees().add(emp); // 부서에 사원 등록
    emp.setDepartment(dept); // 사원에 부서정보 등록
  }
}