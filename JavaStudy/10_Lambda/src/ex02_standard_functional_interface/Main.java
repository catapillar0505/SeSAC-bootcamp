package ex02_standard_functional_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 매개변수가 함수형 인터페이스를 전달할 경우 : 람다식
public class Main {
  public static void main(String[] args) {
    executeConsumer("홍길동", name -> System.out.println("이름: " + name));
    executeSupplier(() -> "hello");
    executeFunction("홍길동", name -> name.length());
    executePredicate(10, num -> num > 0);
    executePredicate(-10, num -> num > 0);
  }

  /**
   * 
   * @param param 람다식에 전달할 값
   * @param predicate 값을 받아 체크한 뒤 boolean을 반환하는 함수
   */
  public static void executePredicate(Integer param, Predicate<Integer> predicate){
    if(predicate.test(param)){
      System.out.println(param + "은 양수!");
    } else{
      System.out.println(param + "은 음수!");
    }

  }

  /**
   * 
   * @param param 람다식에 전달할 값
   * @param function 값을 받아서 가공하여 반환하는 함수 (람다식)
   */
  public static void executeFunction(String param, Function<String, Integer> function){
    Integer result = function.apply(param);
    System.out.println("Function 결과: " + result);   
  }

  /**
   * 
   * @param supplier 값을 반환하는 함수 = 람다식
   */
  public static void executeSupplier(Supplier<String> supplier) {
    String result = supplier.get();
    System.out.println("supplier 결과:" + result);
  }

  /**
   * 
   * @param param    람다식에 전달할 값
   * @param consumer 값을 받아 사용할 람다식
   */
  public static void executeConsumer(String param, Consumer<String> consumer) {
    consumer.accept(param);
  }

}
