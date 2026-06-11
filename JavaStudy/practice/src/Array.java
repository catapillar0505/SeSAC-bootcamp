import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Array {
  public static void main(String[] args) {
    // answer_01();
    // answer_02();
    // answer_03();
    // answer_04();
    // answer_05();
    // answer_06();
    //answer_07(78);
    //answer_07_2(List.of(0, 1, 1, 1, 0, 0, 1));
    answer_08();
  }

  // 1. 다음 정수형 배열에 저장된 모든 요소의 합계와 평균을 출력하세요.
  // int[] numbers = {4, 7, 9, 12, 17, 19, 24, 28, 30};
  static void answer_01() {
    Integer[] numbers = { 4, 7, 9, 12, 17, 19, 24, 28, 30 };
    List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
    int sum = list.stream().collect(Collectors.summingInt(n -> n));
    int sum2 = list.stream().mapToInt(n -> n).sum();
    double average = (double) sum / list.size();
    System.out.println(sum + " " + average + " " + sum2);

  }

  // 2. 다음 정수형 배열에 저장된 모든 요소 중 최대값과 최소값을 출력하세요.
  // int[] numbers = {42, 17, 93, 120, 117, 59, 24, 28, 39};
  static void answer_02() {
    Integer[] numbers = { 42, 17, 93, 120, 117, 59, 24, 28, 39 };
    List<Integer> list = Arrays.asList(numbers);
    Integer max = list.stream().max(Comparator.naturalOrder()).get();
    Integer min = list.stream().min(Comparator.naturalOrder()).get();

    System.out.println(max + " " + min);
  }

  // 3. 다음 배열의 길이를 4로 늘려서 "autumn", "winter"를 저장하세요.
  static void answer_03() {
    String[] seasons = { "spring", "summer" };
    List<String> list = new ArrayList<>(Arrays.asList(seasons));
    list.add("autumn");
    list.add("winter");
    System.out.println(list);

  }

  // 4. 다음 정수형 배열의 모든 요소들의 저장 순서를 뒤집으세요.
  static void answer_04() {
    Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };
    List<Integer> list = Arrays.asList(numbers);
    List<Integer> reversed = list
        .stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    System.out.println(reversed);
  }

  // 5. 다음 객체형 배열이 오름차순으로 정렬되어 있으면 true, 아니면 false를 boolean result 변수에 저장하세요.
  static void answer_05() {
    Integer[] numbers = { 1, 2, 3, 4, 5, 0 };
    List<Integer> list = Arrays.asList(numbers);
    boolean result = list.stream()
        .sorted()
        .collect(Collectors.toList())
        .equals(list);
    System.out.println(result);

  }

  // 6. uppers 배열에는 대문자를 순서대로 저장하고, lowers 배열에는 소문자를 순서대로 저장하세요.
  // 배열의 타입은 char[]로 처리하세요.
  static void answer_06() {
    char[] uppers = new char[26];
    char[] lowers = new char[26];

    for (int i = 0; i < 26; i++) {
      uppers[i] = (char) ('A' + i);
      lowers[i] = (char) ('a' + i);
    }
    System.out.println(Arrays.toString(uppers));
    System.out.println(Arrays.toString(lowers));
  }

  // 7. 10진수(number)를 2진수로 변환한 결과를 int[] binary에 저장하세요.
  // 스트림에 접근할때는 .stream() 인덱스에 접근할때는 intstream.range
  static void answer_07(int number) {
    List<Integer> binary = new ArrayList<>();
    while (number > 0) {
      binary.add(number % 2);
      number /= 2;
    }
    System.out.println("2진수: " + binary);

  }

  static void answer_07_2(List<Integer> binary) {
    int decimal = IntStream.range(0, binary.size())
        .map(i -> binary.get(i) * (int) Math.pow(2, i))
        .sum();
    System.out.println("10진수: "+decimal);

  }

  // 8. 아래 apt 배열에는 각 가구당 인원수가 저장되어 있습니다.
  // 각 층마다 총 몇 명이 거주하는지 출력하세요.
  // int[][] apt = {
  // {2, 5}, // 1층: 1호에 2명, 2호에 5명 거주
  // {3, 4}, // 2층: 1호에 3명, 2호에 4명 거주
  // {1, 4},
  // {2, 3},
  // {3, 3}
  // };
  // [출력 예시]
  // 1층 : 7명
  // 2층 : 7명
  // ...

  static void answer_08(){
    int[][] apt = {
  {2, 5}, // 1층: 1호에 2명, 2호에 5명 거주
  {3, 4}, // 2층: 1호에 3명, 2호에 4명 거주
  {1, 4},
  {2, 3},
  {3, 3}
  };
  
  for(int i =0;i<apt.length;i++){
    int sum = 0;
    for(int j=0;j<apt[i].length;j++){
      sum += apt[i][j];
    }
    System.out.println((i+1)+"층: "+sum+"명");
  }
  }

  // 9. 2단부터 9단까지 구구단을 String[][] gugudan 2차원 배열에 저장하세요.

  // 10. 다음 2차원 배열 T의 모든 요소를 시계 방향으로 90도 회전한 상태로 바꾸세요.
  // int[][] T = {
  // {1, 1, 1, 1, 1},
  // {0, 0, 1, 0, 0},
  // {0, 0, 1, 0, 0},
  // {0, 0, 1, 0, 0},
  // {0, 0, 1, 0, 0}
  // };
  static void answer_09(){
     int[][] T = {
   {1, 1, 1, 1, 1},
   {0, 0, 1, 0, 0},
   {0, 0, 1, 0, 0},
   {0, 0, 1, 0, 0},
   {0, 0, 1, 0, 0}
   };
   int[][] temp = new int[5][5];
   // 첫번째 행 -> 마지막 열
   
   
  }
}
