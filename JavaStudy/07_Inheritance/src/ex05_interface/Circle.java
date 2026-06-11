package ex05_interface;

public class Circle implements Shape {

  // 필드
  private double radius; // 반지름

  // 생성자
  public Circle(double radius) {
    this.radius = radius;
  }

  // 메소드
  // 인터페이스 구현체는 반드시 모든 추상메소드를 오버라이드 해야한다.
  @Override
  public double getPerimeter() {
    return Math.PI * 2 * radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

}
