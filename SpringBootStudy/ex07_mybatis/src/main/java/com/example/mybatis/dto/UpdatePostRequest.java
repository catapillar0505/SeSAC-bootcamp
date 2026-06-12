package com.example.mybatis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePostRequest(
    @NotBlank(message = "게시글 제목 필수") String title,
    String content) {
}
