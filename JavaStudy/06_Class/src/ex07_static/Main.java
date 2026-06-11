package ex07_static;

public class Main {
  public static void main(String[] args) {

    // 정적 메서드: 객체 생성 없이 클래스로 메서드를 호출합니다.

    System.out.println(Calculator.PI);

    int result = Calculator.add(1, 2);
    System.out.println(result);

  }
}
