package ex03_throws;

public class Calculator{
  // 메서드를 호출한 곳으로 던져진다.
  /**
   * 
   * @param a
   * @param b
   * @throws NumberFormatException
   */
  public static void div(String a, String b) throws NumberFormatException{
    int x = Integer.parseInt(a);
    int y = Integer.parseInt(b);
    System.out.println("나누기:" + (x/y));
  }
  
  public static void mod(String a, String b) throws NumberFormatException{
    int x = Integer.parseInt(a);
    int y = Integer.parseInt(b);
    System.out.println("몫:" + (x%y));
  }
}
