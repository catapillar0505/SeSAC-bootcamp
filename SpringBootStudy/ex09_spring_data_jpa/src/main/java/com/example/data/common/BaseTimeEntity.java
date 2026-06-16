package com.example.data.common;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass // 자식 엔티티에 의해 참조되는 부모인 수퍼클래스다 -> 엔티티에 포함되므로 @Entity 생략
@EntityListeners(AuditingEntityListener.class) // 엔티티의 상태 변화(생성,변경)를 감지하여 날짜를 자동으로 입력
public abstract class BaseTimeEntity { // abstract를 안 붙이면 문법적으로는 new 가능하니, 상속 전용 클래스라는 설계 의도를 컴파일러가 보장해주도록 abstract를 붙이는 게 좋다

  @CreatedDate // 엔티티 생성 시간을 자동으로 저장
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate // 엔티티 값이 변경된 시간을 자동으로 저장
  private LocalDateTime updatedAt;

}
