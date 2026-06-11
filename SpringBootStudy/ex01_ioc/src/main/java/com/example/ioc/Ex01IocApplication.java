package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 컴포넌트 스캔 => 현재, 하위 패키지에서 컴포넌트 찾음
public class Ex01IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex01IocApplication.class, args);
	}

}
