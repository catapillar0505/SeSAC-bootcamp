package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper // 나는 xml mapper를 호출할 때 사용하는 인터페이스
public interface UserMapper {
  long countAll(); // xml 매퍼에서 id가 count all인 쿼리 실행하
}
