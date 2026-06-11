package com.example.aop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.aop.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor // 생성자 주입을 통한 DI
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/aop-test")
  public String aopTest(){
    System.out.println("orderservice 클래스: "+ orderService.getClass());
    System.out.println("=====");
    String result = orderService.createOrder("item-001");
    System.out.println("=====");
    return result;
  }
  

}
