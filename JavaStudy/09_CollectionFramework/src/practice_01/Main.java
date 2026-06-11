package practice_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
  // 실무에서도 컬렉션에 담을 때만 Integer, 꺼내서 연산할 때는 int로 받는 게 기본 관례
  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>();
    nums.add(85);
    nums.add(92);
    nums.add(78);
    nums.add(100);
    nums.add(95);
    int sum = 0;

    for (int i : nums) {
      sum += i;
    }

    double average = 0.0;

    average = (double) sum / nums.size();
    System.out.println("점수리스트: "+nums);
    System.out.println("합계: " + sum + "\n평균: " + average);

  }

}
