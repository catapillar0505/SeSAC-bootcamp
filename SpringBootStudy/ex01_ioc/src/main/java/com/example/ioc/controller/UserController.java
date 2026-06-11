package com.example.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ioc.dto.UserDto;
import com.example.ioc.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
public class UserController {

  // 1. 필드 주입
  // @Autowired
  // private NotificationService notificationService;

  // 2. 세터 주입 - 세터의 매개변수로 주입 (세터 하나에 다 몰빵 가능)

  // private NotificationService notificationService;

  // public void setNotificationService(NotificationService notificationService) {
  // this.notificationService = notificationService;
  // }

  // 3. 생성자 주입
  // private NotificationService notificationService;

  // @Autowired // 스프링 4.3 이후 생성자가 1개인 경우 생략 가능
  // public UserController(NotificationService notificationService) {
  // this.notificationService = notificationService;
  // }

  // 4. 실무 DI
  // 필드 선언시 final 키워드를 추가합니다 -> final을 통해 객체 NPE 방지, 객체 불변성 유지, 순환참조 방지
  // final 붙이면 필드주입, 세터주입 불가능

  private final NotificationService notificationService;
  private final ObjectMapper objectMapper;

  public UserController(
      // NotificaionService 타입의 빈이 2개 이상있으면 이름으로 구분 가능
      @Qualifier("smsNotificationService") NotificationService notificationService,
      ObjectMapper objectMapper) {
    this.notificationService = notificationService;
    this.objectMapper = objectMapper;
  }

  @RequestMapping(value = "/join", method = RequestMethod.GET)
  public String createUser() {
    notificationService.sendNotification("반갑습니다");
    return "반갑습니다";
  }

  @RequestMapping(value="/modify", method =RequestMethod.POST)
  public String modifyUser() {
    notificationService.sendNotification("수정되었습니다.");
    return "수정되었습니다.";
  }

  @RequestMapping("/json-test")
  public void jsonTest() {
    try {
      // 1. 자바 객체 -> json (직렬화 = serialization)
      UserDto dto = new UserDto("홍길동", 30);
      String jsonString = objectMapper.writeValueAsString(dto);
      System.out.println("생성된 json: " + jsonString);

      // 2. json 문자열을 자바 객체로 역직렬화(DeSerialization)
      String InputJson = "{\"name\":\"김철수\", \"age\":\"40\"}";
      UserDto resulDto = objectMapper.readValue(InputJson, UserDto.class);
      System.out.println("생성된 DTO: " + resulDto);

    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("예외 발생 사유: " + e.getMessage());
    }
  }

}
