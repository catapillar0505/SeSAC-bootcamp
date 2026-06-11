package ex01_class;

public class Main {
  public static void main(String[] args) {

    // 클래스가 곧 타입이다.

    // 클래스를 타입으로 가지는 변수는 "객체"이다.

    // 객체 선언 ()

    // 패키지 명시를 안 해도 되는 3가지 경우
    // 1. 같은 패키지에 있는 경우
    // 2. java.lang 패키지에 있는 경우 (String, System 등)
    // 3. import 문을 작성한 경우 (패키지 명시를 미리 해 둔 경우)

    Car car;

    // 객체 생성 (동적 할당을 통해 만듦)
    car = new Car();

    // 확인
    System.out.println(car);

    // 객체의 값 참조하기 (마침표 . 연산)
    car.model = "G80";
    car.price = 8000;
    System.out.println(car.model);
    System.out.println(car.price);

  }
}
