package ex03_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    //리스트
    List<String> members = Arrays.asList("kim","jessica","john","tomson");

    // 원본 리스트 -> stream
    Stream<String> stream = members.stream();
    
    //최종 연산
    // stream.forEach(member -> System.out.println(member));

    //중간 연산 + 최종 연산
    List<String> list = stream
    .filter(member -> member.length() <= 4)
    .map(m->m+"님")
    .collect(Collectors.toList());

    System.out.println(list);

    

  }
  
}
