package com.example.book_rest_api.dto;

import lombok.Builder;

@Builder
public record BookDto(
  Long isbn,
  String title,
  int price
) {
}
