package ex01_generic_class;

public class Main {
  public static void main(String[] args) {
    
    // 타입을 결정한뒤 객체 생성
    Box<String> sBox = new Box<String>();

    // 타입이 결정된 이후에는 문법적으로 String만 지원함
    sBox.setContent("hello");
    System.out.println(sBox.getContent());

    // 제네릭 타입은 오직 참조 타입만 가능 - 기본 타입이 필요한 경우 래퍼 클래스 사용
    Box<Integer> iBox = new Box<Integer>();
    iBox.setContent(10);
    System.out.println(iBox.getContent());;
  }
}
