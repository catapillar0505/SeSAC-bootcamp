package com.example.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.domain.Post;
import com.example.mybatis.dto.CreatePostRequest;
import com.example.mybatis.dto.PageResponse;
import com.example.mybatis.dto.PostResponse;
import com.example.mybatis.dto.UpdatePostRequest;
import com.example.mybatis.exception.CustomException;
import com.example.mybatis.exception.ErrorCode;
import com.example.mybatis.mapper.PostMapper;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
  private final PostMapper postMapper;

  @Transactional
  public PostResponse createPost(CreatePostRequest createPostRequest) {
    // post의 id, 날짜 없음
    Post post = Post.builder()
        .userId(createPostRequest.userId())
        .title(createPostRequest.title())
        .content(createPostRequest.content())
        .build();

    // 제약조건 위배를 대비한 코드 -> id, 날짜 생김
    postMapper.save(post);

    return findById(post.getId());
  }

  public PostResponse findById(Long id) {
    Post post = postMapper.findById(id)
        .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

    return PostResponse.from(post);
  }

  public PageResponse<PostResponse> getPosts(int page, int size, String sort) {

    long offset = (page - 1) * size;
    long totalElements = postMapper.countAll();
    int totalPages = (int) Math.ceil((double) totalElements / size);

    List<Post> posts = postMapper.findAll(offset, size, sort);

    List<PostResponse> contents = posts.stream()
        .map(post -> PostResponse.from(post))
        // 파라미터를 메서드에 전달하는게 전부라면 .map(PostRespone::from) - 메서드 참
        .toList();

    return new PageResponse<>(contents, page, size, totalPages, totalElements, sort);

  }

  @Transactional
  public PostResponse updatePost(Long id, UpdatePostRequest updatePostRequest) {
    Post post = postMapper.findById(id)
        .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

    Post newPost = Post.builder()
        .id(id)
        .userId(post.getUserId())
        .title(updatePostRequest.title())
        .content(updatePostRequest.content())
        .createdAt(post.getCreatedAt())
        .user(post.getUser())
        .build();

    postMapper.update(newPost); // 수정
    return PostResponse.from(newPost);
  }

  @Transactional
  public void deletePost(Long id) {
    postMapper.findById(id)
        .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

    postMapper.deleteById(id);
  }

}
