package com.example.ioc.service;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationService implements NotificationService{

  @Override
  public void sendNotification(String message) {
    System.out.println("[문자 알림]" + message);
  }

}
