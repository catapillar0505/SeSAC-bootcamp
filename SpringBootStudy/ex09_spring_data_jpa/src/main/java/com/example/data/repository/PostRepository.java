package com.example.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.data.domain.Post;

// Spring Data JPA는 JpaRepository<T, ID> 인터페이스를 상속받으면 필요한 구현체를 알아서 만들어준다.

// 이미 완성된 메서드
/* 1. 저장: save(T entity) - persist가 포함
   2. 조회: findById(ID id), findAll(), count(), exitsById()
   3. 삭제: deleteById()
   4. 수정: JpaRespository가 지원하지 않음. 변경감지 이용 - 도메인에 비즈니스 메서드로 직접 구현 
*/

public interface PostRepository extends JpaRepository<Post, Long> {

  // --------- 게시글 단건 조회

  // [JPQL] 게시글과 댓글을 조인하여 한번에 조회하도록 JPQL 작성
  @Query("select p from Post p left join fetch p.comments where p.id = :id") // inner join이면 댓글 없는 포스트는 제외됨
  Post findPostWithComments(@Param("id") Long id);

  // ------- 제목에 특정 키워드가 포함된 게시글 목록 조회

  // [쿼리 메서드] - find + 엔티티 + By + 조건
  // 쿼리 이름만 만들면 쿼리 알아서 짜서 데이터 가져오는 메서드
  // 조건 파라미터가 처음에 와야함
  Page<Post> findByTitleContaining(String keyword, Pageable pageable);

}
