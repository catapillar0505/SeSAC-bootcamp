package com.example.valid.dto;

import java.time.LocalDateTime;

import lombok.Builder;

// db와 소통할 dto
@Builder
public record MemberDto(
  Long id,
  String userName,
  String email,
  LocalDateTime createdAt
) 
{

}
