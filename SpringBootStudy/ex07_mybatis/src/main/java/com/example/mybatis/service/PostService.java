package com.example.mybatis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mybatis.domain.Post;
import com.example.mybatis.dto.CreatePostRequest;
import com.example.mybatis.dto.PostResponse;
import com.example.mybatis.exception.CustomException;
import com.example.mybatis.exception.ErrorCode;
import com.example.mybatis.mapper.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostMapper postMapper;

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
    .orElseThrow(()->new CustomException(ErrorCode.POST_NOT_FOUND));

    return PostResponse.from(post);
  }

}
