package com.example.book_rest_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.book_rest_api.dto.BookDto;

@Service
public class BookService {
  private final ConcurrentHashMap<Long, BookDto> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1); // ID 자동증가

  public List<BookDto> getAllBooks(){
    return store.values().stream().toList();
  }
  public BookDto saveBook(BookDto newBook){
    Long id = sequence.getAndIncrement();
    store.put(id,newBook);
    return newBook;
  }
  public BookDto updateBook(Long isbn, BookDto newBook){
    store.put(isbn, BookDto.builder()
    .isbn(newBook.isbn())
    .title(newBook.title())
    .price(newBook.price())
    .build());
    return store.get(isbn);
  }


}
