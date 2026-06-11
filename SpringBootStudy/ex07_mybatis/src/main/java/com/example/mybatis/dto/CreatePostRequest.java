package com.example.mybatis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostRequest(

    @NotNull(message = "작성자 아이디는 필수항목입니다") Long userId,

    @NotBlank(message = "게시글 제목 필수") String title,

    String content) {
}
