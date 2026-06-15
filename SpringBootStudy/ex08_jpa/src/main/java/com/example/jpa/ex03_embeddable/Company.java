package com.example.jpa.ex03_embeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Company {

  @Id
  private Long id;

  private String name;

  @Embedded // 임베디드 타입 포함 (Address의 city, zipcode, street 칼럼이 생김)
  private Address officeAddress;

  @Embedded // 임베디드 타입 포함 (칼럼 이름 충돌 -> 칼럼 이름 재정의)
  @AttributeOverrides({
      @AttributeOverride(name = "city", column = @Column(name = "factory_name")),
      @AttributeOverride(name = "street", column = @Column(name = "factory_street")),
      @AttributeOverride(name = "zipCode", column = @Column(name = "factory_zip_code"))
  })
  private Address factoryAddress;

}
