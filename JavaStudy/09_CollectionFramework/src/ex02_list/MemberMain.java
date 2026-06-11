package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {
  public static void main(String[] args) {
    // 1. arrayList 생성
    List<Member> members = new ArrayList<>();

    //2. 요소 추가
    members.add(new Member("지수", 20));
    members.add(new Member("제니", 23));
    members.add(new Member("리사", 25));
    members.add(new Member("로제", 30));

    //3. 요소 확인
    for(Member m : members){
      System.out.println(m);
    }

    //4. 요소 삭제
    boolean isRemoved = members.remove(new Member("지수", 20));
    System.out.println(isRemoved? "삭제성공":"삭제실패");

    //5. 존재 확인
    Member target = new Member("로제",30);
    if(members.contains(target)){
      System.out.println(target+ "확인");
    } else {
      System.out.println(target+"없다");
    }

    //6. for문 순회
    for(int i=0, length = members.size();i<length;i++){
      Member m = members.get(i);
      System.out.println("이름: " + m.getName() + " 나이: " + m.getAge());
    }

  }
}
