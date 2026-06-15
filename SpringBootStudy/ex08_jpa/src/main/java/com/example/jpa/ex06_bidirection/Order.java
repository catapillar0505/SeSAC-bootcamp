package com.example.jpa.ex06_bidirection;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderNumber;

  // 양방향 연관관계의 주인이 아니라고 명시해주기
  // mappedBy = 참조한다가 아닌 참조된다 (찾아진다)
  // 반대편의 필드명을 그대로 작성하기

  // CascadeType.ALL = 영속성 전이 (부모만 영속화해도 자식이 함께 영속화 됨)
  // orphanRemoval = true 고아 (리스트에는 없지만 실제로는 존재하는 자식 엔티티)
  // 고아가 발생하면 해당 자식 엔티티를 삭제하기 위한 DELETE문 자동 생성
  // 고아 만드는 방법 = 리스트.remove(삭제할엔티티인덱스 or 엔티티자체)
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderItem> orderItems = new ArrayList<>();

  public Order(String orderNumber) {
    this.orderNumber = orderNumber;
  }
  // Order order = new ~
  // OrderItem item = new ~
  // order.addOrderItem(item);

  // 비즈니스 메서드 (편의상 작성)
  public void addOrderItem(OrderItem item){
    this.orderItems.add(item); // Order123 주문에 ipad를 넣는다.
    if (item.getOrder() == null) item.setOrder(this);
  }


}
