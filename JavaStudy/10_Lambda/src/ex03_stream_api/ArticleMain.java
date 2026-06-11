package ex03_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArticleMain {
  public static void main(String[] args) {
    
    // 원본 리스트 생성
    List<Article> articles = Arrays.asList(
      new Article("제목1",114),
      new Article("제목2",4),
      new Article("제목3",300),
      new Article("제목4",234),
      new Article("제목5",31)
    );

    // stream api를 이용해서 조회수가 100 이상인 기사의 제목을 List에 저장하세요

    List<String> titles = articles
    .stream()
    .filter(a -> a.getViewCount() >= 100)
    .map(a -> a.getTitle())
    .collect(Collectors.toList());

    System.out.println(titles);
    
  

  }
  
}
