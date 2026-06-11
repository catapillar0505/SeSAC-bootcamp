package ex03_lombok;

import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    // 1. HashSet (해시 기반 집합 - 인덱스 없고, 데이터 중복 저장 불가)
    Set<String> members = new HashSet<>();

    // 2. 요소 추가
    members.add("지수");
    members.add("로제");
    members.add("제니");
    members.add("리사");

    // 3. 요소 하나씩 가져오기
    // 인덱스 기반으로 불가능
    for(String s:members){
      System.out.println(s);
    }

    //4. 요소 삭제하기
    members.remove("지수");

    //5. 존재 확인
    if(members.contains("로제")){
      System.out.println("존재한다");
    }else{
      System.out.println("없다");
    }

    //6. for문 순회
     for(String s:members){
      System.out.println(s);
    }
  }
}
