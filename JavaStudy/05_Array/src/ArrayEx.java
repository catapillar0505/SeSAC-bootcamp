import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx {
  public static void main(String[] args) {

    // 배열: 여러 변수를 하나의 이름으로 관리
    // int a, b, c;
    // int[] arr;

    // 배열 선언
    String[] blackPink;

    // 사용자 콘솔 입력 (배열의 길이를 사람이 정하도록)
    Scanner sc = new Scanner(System.in);
    System.out.println("4를 입력하세요 > ");
    int a = sc.nextInt();

    // 배열 생성 (실행 중에 메모리를 할당하는 것: 동적 할당 -> Heap 영역)
    blackPink = new String[a];

    // 배열 요소 (Element: 각 변수를 의미)
    blackPink[0] = "지수";
    blackPink[1] = "로제";
    blackPink[2] = "리사";
    blackPink[3] = "제니";

    // 배열 길이
    System.out.println(blackPink.length);

    // 출력
    for (int i = 0; i < blackPink.length; i++) {
      System.out.println(blackPink[i]);
    }

    // 정적 초기화 (배열 선언 시에만 가능한 초기화)
    String[] seasons = { "봄", "여름", "가을", "겨울" };
    for (String season : seasons) {
      System.out.println(season);
    }

    // 동적 초기화 (배열 선언과 분리가 가능한 초기화)
    String[] hobbies;
    hobbies = new String[] { "레고", "독서" };
    for (String hobby : hobbies) {
      System.out.println(hobby);
    }

    // 배열의 길이는 수정 불가
    // 배열의 길이를 늘이는 방법: 새 배열을 만들어서 이사하기
    String[] names = { "김철수", "홍길동" };
    String[] newArray = new String[5];
    System.arraycopy(names, 0, newArray, 0, names.length);
    names = newArray;
    System.out.println(Arrays.toString(names));

  }
}
