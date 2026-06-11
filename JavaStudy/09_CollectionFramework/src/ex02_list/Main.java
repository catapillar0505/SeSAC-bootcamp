package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    // 배열리스트
    // 배열과 같은 원리로 동작함

    // 1. 생성 (생성 시점에 타입 결정)
    List<String> members = new ArrayList<>();

    // 2. 요소 추가하기
    members.add("지수");
    members.add("제니");
    members.add("로제");
    members.add("리사");

    // 3. 각 요소 확인
    System.out.println(members);
    for (String s : members) {
      System.out.println(s);
    }
    
    // 4. 길이 확인
    System.out.println(members.size());
    
    // 5. 삭제
    String removed = members.remove(0);
    System.out.println(removed);
    
    boolean isRemoved = members.remove("지수");
    System.out.println(isRemoved ? "삭제 성공" : "삭제 실패");
    
    System.out.println(members);
    
    //6. 요소 존재 여부 확인
    String target = "윤아";
    if(members.contains(target)){
      System.out.println("존재함");
    }
    else{
      System.out.println("없다");
    }

    // 7. for문 순회
    System.out.println("foreach문");
    for (String s : members) {
      System.out.print(s + " ");
    }

    System.out.println("\n인덱스 for문");
    // 안좋은 예시
    for (int i =0;i<members.size();i++){
      System.out.print(members.get(i)+" ");
    }

    // 좋은 예시 (초기화 블록에서 size 선언해서 낭비 줄이기)
    for (int i =0, length = members.size();i<length;i++){
      System.out.print(members.get(i)+" ");
    }
  }
}
