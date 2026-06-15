package com.example.jpa.ex05_one_to_many;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @OneToMany(cascade = CascadeType.PERSIST) // cascade가 함께, 함께 등록하라는 뜻
  // CascadeType.PERSIST : POST 영속화 시 연관관계를 가진 PostComment를 함께 영속화
  @JoinColumn(name = "post_id") // Post가 아닌 PostComment 자식 테이블에 생성할 외래키 칼럼명을 작성 - manytoone때와 달리 내 테이블이 아니라 자식에 생김
  private List<PostComment> comments = new ArrayList<>(); // 게시글이 만들어지기 전에 댓글이 먼저 달릴 수 없으니 빈값으로만 만들어놓기

  public Post(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Post [id=" + id + ", title=" + title + ", comments=" + comments + "]";
  }

  // 비즈니스 편의상 만든 메서드
  public void addComment(PostComment comment) {
    this.comments.add(comment);
  }

  

}
