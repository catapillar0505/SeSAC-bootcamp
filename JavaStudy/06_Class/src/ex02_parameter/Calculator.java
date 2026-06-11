package ex02_parameter;

class Main1 {
  public static void main(String[] args) {

    // 클래스타입 객체명;
    Calculator myCalc;
    myCalc = new Calculator();

    myCalc.add(1, 2);
    myCalc.add(1.5, 2.5);

    myCalc.add(new int[] {1,2,3,4,5});

    myCalc.multiply(1, 2, 3, 4);

  }
}

public class Calculator {

  // 메서드 오버로딩 (Overloading)
  // 같은 이름의 메서드 + 개수나 타입이 다른 매개변수

  void add(int a, int b) {
    System.out.println(a + b);
  }

  void add(double a, double b) {
    System.out.println(a + b);
  }

  void add(int[] numbers) {
    int result = 0;
    for (int n : numbers) {
      result += n;
    }
    System.out.println(result);
  }

  // void multiply(int a, int b) {
  // System.out.println(a * b);
  // }

  // void multiply(int a, int b, int c) {
  // System.out.println(a * b * c);
  // }

  void multiply(int a, int b, int... numbers) { // 가변 인자 처리를 위한 말줄임표(...)
    // 가변 인자는 실제로는 배열로 처리됩니다.
    int result = a * b;
    for (int n : numbers) {
      result *= n;
    }
    System.out.println(result);
  }

}
