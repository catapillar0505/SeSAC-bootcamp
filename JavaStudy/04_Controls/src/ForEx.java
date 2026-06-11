public class ForEx {
  public static void main(String[] args) {
    // 1 ~ 10
    for (int i = 1; i <= 10; i++) {
      System.out.println(i);
    }

    // 10 ~ 1
    for (int i = 10; i >= 1; i--) {
      System.out.println(i);
    }

    // 무한 루프
    for (;;) {
      System.out.println("Hello World");
    }
  }
}
