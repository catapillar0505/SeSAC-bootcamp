package com.example.mybatis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.domain.Post;
import com.example.mybatis.dto.CreatePostRequest;
import com.example.mybatis.dto.PageResponse;
import com.example.mybatis.dto.PostResponse;
import com.example.mybatis.dto.UpdatePostRequest;
import com.example.mybatis.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;

  @PostMapping
  public ResponseEntity<PostResponse> createPost(@Valid @RequestBody CreatePostRequest request) {
    PostResponse response = postService.createPost(request);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
    return ResponseEntity.ok(postService.findById(id));
  }

  @GetMapping
  public ResponseEntity<PageResponse<PostResponse>> getPosts(
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "size", defaultValue = "2") int size,
      @RequestParam(value = "sort", defaultValue = "DESC") String sort) {

    return ResponseEntity.ok(postService.getPosts(page, size, sort));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PostResponse> updatePost(@PathVariable Long id, @Valid @RequestBody UpdatePostRequest request) {
    return ResponseEntity.ok(postService.updatePost(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Long id) {
    postService.deletePost(id);
    return ResponseEntity.noContent().build();
  }

}
