import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Operator {

  public static void main(String[] args) {
    // answer_01(2507);
    // answer_02();
    // answer_03();
    // answer_04(2);
    // answer_05();
    answer_06();

  }

  // 세 자리로 된 정수(100~999) number에 저장된 값의 백의 자리를 변수 hundreds, 십의 자리를 변수 tens, 일의 자리를
  // 변수 units에 저장하세요.
  static void answer_01(int number) {
    int thousand = number / 1000;
    int hundreds = (number % 1000) / 100;
    int tens = (number % 100) / 10;
    int units = number % 10;
    System.out.println(thousand + " " + hundreds + " " + tens + " " + units);
  }

  // 두 정수 변수 m, n에 저장된 값을 서로 교환하여 저장하세요.
  static void answer_02() {
    int m = 6, n = 4, temp = 0;
    temp = n;
    n = m;
    m = temp;
    System.out.println("m: " + m + ", n: " + n);
  }

  // 세 개의 정수 변수 a, b, c에 저장된 값 중 가장 큰 수를 max 변수에 저장하세요.
  static void answer_03() {
    int a = 10, b = 20, c = 30;
    List<Integer> list = new ArrayList<>();
    list.add(a);
    list.add(b);
    list.add(c);
    int max = Collections.max(list);
    System.out.println(max);

    Optional<Integer> max2 = list.stream().max(Comparator.naturalOrder());
    System.out.println(max2);
  }

  // 정수 변수 month에 저장된 값이 3~5이면 "봄", 6~8이면 "여름", 9~11이면 "가을" 12,1,2이면 "겨울"을 season
  // 변수에 저장하세요.
  static void answer_04(int month) {
    int mod = month % 12;
    String season = mod <= 2 ? "winter"
        : mod <= 5 ? "spring" : mod <= 8 ? "summer" : "autumn";
    System.out.println(season);
  }

  // 정수 변수 data를 0으로 비트 마스킹(Bit Masking)하는 코드를 작성해 보세요.
  static void answer_05() {
    int data = 255;
    int mask = 0;
    int result = data & mask;
    System.out.println(result);
  }

  // 정수 변수 data에 255를 저장합니다. data는 2진수로 11111111입니다. 이 때 하위 4개 비트만 남기려면(결과*
  // 00001111) 변수 mask 값은 얼마여야 하는지 생각해 보고 코드를 작성해 보세요.
  // 비트 마스킹 & 보기 싫은걸 0으로 지워버림
  static void answer_06() {
    int data = 255; // 1111 1111
    int mask = 15; // 0000 1111
    int result = data & mask; // 0000 1111
    System.out.println(result);
  }
}
