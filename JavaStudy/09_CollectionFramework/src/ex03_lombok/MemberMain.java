package ex03_lombok;

import java.util.HashSet;
import java.util.Set;

public class MemberMain {
  public static void main(String[] args) {
    // 확인
    // 1. 중복해서 저장해보기
    Set<Member> members = new HashSet<>();

    members.add(new Member("지수", 21));
    members.add(new Member("지수", 21));

    // 2. contains로 존재여부 확인
    if (members.contains(new Member("지수", 21))) {
      System.out.println("존재함");
    } else {
      System.out.println("존재안함");
    }

    // 3. 객체 정보 출력해보기
    for (Member m : members) {
      System.out.println(m);
    }
  }
}
