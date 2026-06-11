public class IfEx {
  public static void main(String[] args) {
    
    int age = 49;

    if (age >= 20) {
      System.out.println("성인");
    } else if (age >= 17) {
      System.out.println("고등학생");
    } else if (age >= 14) {
      System.out.println("중학생");
    } else if (age >= 8) {
      System.out.println("초등학생");
    } else {
      System.out.println("미취학");
    }

  }
}
