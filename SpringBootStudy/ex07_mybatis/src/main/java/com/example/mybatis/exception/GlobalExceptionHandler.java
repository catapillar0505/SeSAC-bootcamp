package com.example.mybatis.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException e) {
    Map<String, String> fieldErrors = new HashMap<>();
    e.getBindingResult().getFieldErrors()
        .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

    Map<String, Object> body = new HashMap<>();
    body.put("code", ErrorCode.INVALID_INPUT_VALUE.getCode());
    body.put("message", ErrorCode.INVALID_INPUT_VALUE.getMessage());
    body.put("errors", fieldErrors);

    return ResponseEntity.badRequest().body(body);
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Map<String, Object>> handleCustomException(CustomException e) {
    Map<String, Object> body = new HashMap<>();
    body.put("code", e.getErrorCode().getCode());
    body.put("message", e.getErrorCode().getMessage());

    return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(body);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleException(Exception e) {
    Map<String, Object> body = new HashMap<>();
    body.put("code", ErrorCode.INTERNAL_SERVER_ERROR.getCode());
    body.put("message", ErrorCode.INTERNAL_SERVER_ERROR.getMessage());

    return ResponseEntity.internalServerError().body(body);
  }

}
