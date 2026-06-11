package com.example.mybatis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.dto.CreatePostRequest;
import com.example.mybatis.dto.PostResponse;
import com.example.mybatis.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;
  
  @PostMapping
  public ResponseEntity<PostResponse> createPost(@Valid @RequestBody CreatePostRequest request){
    PostResponse response = postService.createPost(request);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostResponse> getPost(@PathVariable Long id){
    return ResponseEntity.ok(postService.findById(id));
  }

  
}
