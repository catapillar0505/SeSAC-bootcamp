package com.example.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.request.dto.UserRequest;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/users")
public class RequestController {

  // 테스트 요청 주소
  // http://localhost:8080/api/users/vl?name="홍길동"&age=30

  // 요청 파라미터 1 (HttpServletRequest 활용)

  @GetMapping("/v1")
  public void legacy(HttpServletRequest request) {
    // 모든 요청 파라미터는 String 타입으로 전달
    String name = request.getParameter("name");
    String strAge = request.getParameter("age");

    // 파라미터가 전달되지 않는 경우
    // 1. 값이 없는 경우 : 빈 문자열("")
    // ?name=&age=30
    // 2. 파라미터 없는 경우 : null
    // ?age=30
    // !strAge.isBlank() && strAge != null
    // 널포인터 예외 발생

    int age = 0;
    if (strAge != null && !strAge.isBlank()) {
      age = Integer.parseInt(strAge);
    }
    System.out.println("이름: " + name + "나이: " + age);
  }
  // 요청 파라미터 2 (@RequestParam)

  @GetMapping("/v2")
  public void requestParam(
      @RequestParam("name") String name,
      @RequestParam(value = "age", required = false, defaultValue = "0") int age) { // 필수인지, 기본값 설정
    System.out.println("이름: " + name + " 나이: " + age);
  }

  // 요청 파라미터 3 (커맨드 객체 - 파라미터를 필드로 가지는 객체)
  @GetMapping("/v3")
  public void commandObject(UserRequest request) {
    System.out.println("조회: " + request);
  }

  // 요청 파라미터 4 요청 본문 (요청을 본문에 담아 보내는 POST 방식)
  // 클라이언트 - JSON , 서버 - 자바 객체
  // 스프링 부트의 MessageConverter는 잭슨이 기본 설정 (spring web)

  @PostMapping("/v4")
  public void requestBody(@RequestBody UserRequest request) {
    System.out.println("등록: " + request);
  }

  // 파일 첨부 요청
  // Method: post
  // encType : multipart/form-data
  // 부트 서버는 nultipartFile 파라미터로 파일 받음
  // 파일을 제외한 나머지 파라미터는 커맨드 객체로 처리 추천
  @PostMapping("/v5")
  public void fileAttach(
      @RequestPart("profile") MultipartFile profile, // 파일 데이터
      UserRequest request // 텍스트 데이터
  ) {
    if (profile.isEmpty()) {
      System.out.println("첨부 파일이 없습니다");
      return;
    } else {
      System.out.println("파일명: " + profile.getOriginalFilename());
      System.out.println("파일크기: " + profile.getSize() + "Bytes");
      System.out.println("텍스트 데이터: " + request);
    }
  }

}