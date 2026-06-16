package com.example.data.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.data.domain.Comment;
import com.example.data.domain.Post;
import com.example.data.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용 트랜잭션

public class PostService {
  private final PostRepository postRepository;

  // 생성
  @Transactional // 읽기 전용이 아님
  public Long createPost(String title, String content) {
    Post post = new Post(title, content);
    return postRepository.save(post).getId();
  }

  // 단건 조회
  public Post getPost(Long id) {
    Post post = postRepository.findPostWithComments(id);
    return post;
  }

  // 목록 조회
  public Page<Post> getPosts(String keyword, Pageable pageable) {
    if (keyword != null && !keyword.isBlank()) {
      return postRepository.findByTitleContaining(keyword, pageable);
    }

    return postRepository.findAll(pageable);

  }

  // 수정
  // find 조회 -> 조회 결과 영속화 -> 더티 체크 -> update 자동 생성
  @Transactional
  public void updatePost(Long id, String title, String content) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다"));
    post.updatePost(title, content);
  }

  // 삭제
  @Transactional
  public void deletePost(Long id) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다"));
    postRepository.delete(post);
  }

  // 댓글 등록
  @Transactional
  public void addComment(Long postId, String content) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다"));
    Comment comment = new Comment(content);

    post.addComment(comment);

  }

}
