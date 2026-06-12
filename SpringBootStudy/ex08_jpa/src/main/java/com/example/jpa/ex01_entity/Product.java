package com.example.jpa.ex01_entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
  name = "products",
  uniqueConstraints = {
    @UniqueConstraint(name = "UC_PRODUCT_CODE", columnNames = {"product_code"}) 
  }
)
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product_code", nullable = false, length = 20)
  private String productCode;

  @Column(name = "product_name", nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private Integer price;

  @Column(name = "registered_at", updatable = false)
  private LocalDateTime registeredAt;

  @Lob
  private String description;

  @Transient
  private String tempSessionId;

  // JPA 스펙상 기본 생성자는 필수 요소임
  // public 권한을 축소해서 protected 권한 사용 권장 (동일 패키지 or 상속 패키지)
  protected Product() {

  }

  public Product(String productCode, String name, Integer price, String description){
    this.productCode = productCode;
    this.name = name;
    this.price = price;
    this.description = description;
    this.registeredAt = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public String getProductCode() {
    return productCode;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public LocalDateTime getRegisteredAt() {
    return registeredAt;
  }

  public String getDescription() {
    return description;
  }

  public String getTempSessionId() {
    return tempSessionId;
  }

  // JPA 엔티티 설계시 @tostring 권장하지 않음, 수동 권장 
  // 왜냐면 상호참조 -> 무한루프
  @Override
  public String toString() {
    return "Product [id=" + id + ", productCode=" + productCode + ", name=" + name + ", price=" + price
        + ", registeredAt=" + registeredAt + ", description=" + description + ", tempSessionId=" + tempSessionId + "]";
  }

  
  

}
