package ex02_parameter;

public class Car {

  // 값 (필드)
  int oil;

  // 메서드(Method): 특정 기능을 수행하는 코드 블록

  // 결과타입 메서드명(매개변수) { }

  /**
   * 메서드 설명을 작성합니다.
   * @param city 뭘 받는지 설명을 작성합니다.
   */
  void drive(String city) {  // 매개변수(Parameter)
    oil -= 10;
    System.out.println(city + "에서 드라이브하기");
  }

  void goToGasStation(int fuel) {
    oil += fuel;
    System.out.println("현재 연료량:" + oil);
  }

}
