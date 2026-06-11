package com.example.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  
  // 빈으로 등록할 객체를 반환
  @Bean
  ObjectMapper objectMapper() { // 빈의 타입 = 클래스, 빈의 이름 = 메소드 이름
    return new ObjectMapper();
  }
}
