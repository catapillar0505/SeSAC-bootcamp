package com.example.data.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.data.common.BaseTimeEntity;

import jakarta.persistence.Column;
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
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTimeEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false, length = 100)
  private String title;

  @Column(columnDefinition = "TEXT") // 자유롭게 컬럼 정의 나열
  private String content;

  @OneToMany(mappedBy = "post") // mappedBY - 참조당하는 쪽
  private List<Comment> comments = new ArrayList<>();

  // 엔티티를 생성하는 방법은 생성자, 빌더 패턴, 정적 메서드 패턴(new를 안하는 것) 무엇을 활용하던 ok - 자주쓰는건 빌더
  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  // 비즈니스 메서드
  public void addComment(Comment comment){
    this.comments.add(comment); // 현재 게시글의 댓글 목록에 등록
    comment.setPost(this); // 댓글이 달린 게시글이 현재 게시글임을 등록
  }

  // 변경 감지를 위한 비즈니스 메서드
  public void updatePost(String title, String content) {
    this.title = title;
    this.content = content;
  }
  
}
