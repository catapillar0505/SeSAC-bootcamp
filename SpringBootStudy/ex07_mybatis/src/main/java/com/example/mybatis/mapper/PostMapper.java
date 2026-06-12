package com.example.mybatis.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatis.domain.Post;

@Mapper // 나는 xml mapper를 호출할 때 사용하는 인터페이스
public interface PostMapper {
  long countAll(); // xml 매퍼에서 id가 count all인 쿼리 실행하

  Optional<Post> findById(Long id);

  List<Post> findAll(@Param("offset") Long offset, @Param("size") int size, @Param("sort") String sort);

  int save(Post post);
  int update(Post post);
  int deleteById(Long id);

}
