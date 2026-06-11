package com.example.book_rest_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_rest_api.dto.BookDto;
import com.example.book_rest_api.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks(){
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @PostMapping
  public ResponseEntity<BookDto> saveBook(@RequestBody BookDto newBookDto){
    return ResponseEntity.status(201).body(bookService.saveBook(newBookDto));
  }

  @PutMapping("/{isbn}")
  public ResponseEntity<BookDto> updateBook(@PathVariable Long isbn, @RequestBody BookDto newBookDto){
    return ResponseEntity.ok(bookService.updateBook(isbn, newBookDto));
  }
}
