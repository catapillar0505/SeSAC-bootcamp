package com.example.response.dto;

import lombok.Builder;

// java 16+ 정식으로 체택된 Record
// 1. 모든 필드가 final 처리 (데이터 불변, setter 불가)
// 2. 컴파일러가 필요한 코드를 자동으로 생성 (생성자, tosting)
// 3. getter 자동 생성, 단 get으로 시작하지 않음 필드명과 동일함
// 4. 빌더패턴과의 콜라보도 가능!
// 매개변수 자리에 필드 적음

public record UserResponse(String name, int age) {

}
