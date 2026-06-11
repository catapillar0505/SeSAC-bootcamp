package ex03_stream_api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 1. lombok으로 보일러플레이트 코드 채우기

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Article {
  private String title;
  private int viewCount;
}
