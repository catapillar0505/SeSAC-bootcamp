package com.example.jpa.ex04_many_to_one;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 자식 엔티티

@Table(name = "items")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = true, length = 100)
  private String itemName;

  // 연관 관계 핵심 부분
  // 아이템 여러개가 하나의 카테고리에 들어감
  @ManyToOne(fetch = FetchType.LAZY)
  // FetchType.EAGER = 즉시 로딩. find 호출시 연관관계를 가진 테이블을 함께 조회하는 것 (디폴트) - 의미없이 left join
  // FetchType.LAZY = 지연 로딩. find 호출시 자신만 조회하고(연관 관계의 데이터는 프록시 객체로 처리) , 연관관계의 테이블은 나중에 필요할 때 조회하는 것 (실무 표준) - select 2개 날림
  @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_item_to_category")) // 조인컬럼에는 부모의 기본키가 들어감
  private Category category;

  public Item(String itemName, Category category) {
    this.itemName = itemName;
    this.category = category;
  }
  
}
