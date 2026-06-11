package com.example.rest_api.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MemberResponse(  Long id,
  String email,
  LocalDateTime createAt) {

  }
