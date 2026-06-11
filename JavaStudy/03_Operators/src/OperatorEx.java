public class OperatorEx {
  public static void main(String[] args) throws Exception {

    {
      // 정수
      int a = 5;
      int b = 2;
      int zero = 0;
      System.out.println(a + b);
      System.out.println(a - b);
      System.out.println(a * b);
      System.out.println(a / b); // 나눈 몫
      // System.out.println(a / zero); // 0으로 나누면? ArithmeticException 발생!
      System.out.println(a % b); // 나눈 나머지
    }

    {
      // 실수
      double a = 5.0;
      double b = 2.0;
      double zero = 0.0;
      System.out.println(a + b);
      System.out.println(a - b);
      System.out.println(a * b);
      System.out.println(a / b); // 나눈 값
      System.out.println(a / zero); // 0으로 나누면? Infinity (무한대)
      System.out.println(a % b); // 나눈 나머지
      System.out.println(a % zero); // 0으로 나눈 나머지는? NaN (숫자가 아님)
    }

    {
      // 증가
      int a = 10;
      System.out.println(a++); // 10 (후위 연산: 출력 후 증가)
      System.out.println(++a); // 12 (전위 연산: 증가 후 출력)
    }

    {
      // 감소
      int a = 10;
      System.out.println(a--); // 10 (후위 연산: 출력 후 감소)
      System.out.println(--a); // 8 (전위 연산: 감소 후 출력)
    }

    {
      int a = 10; // 10을 a에 대입
      System.out.println(a);

      // Compound Assignment : 복합 대입 연산 (+=, -=, *=, /=, %= 등)
      int x = 10;
      x += 10; // x = x + 10;
      System.out.println(x);
      x -= 10; // x = x - 10;
      System.out.println(x);
      x *= 10; // x = x * 10;
      System.out.println(x);
      x /= 10; // x = x / 10;
      System.out.println(x);
      x %= 10; // x = x % 10;
      System.out.println(x);
    }

    {
      int x = 10;
      int y = 20;

      System.out.println(x > y); // false
      System.out.println(x >= y); // false
      System.out.println(x < y); // true
      System.out.println(x <= y); // true
      System.out.println(x == y); // false
      System.out.println(x != y); // true
    }

    {
      int x = 10;
      int y = 20;

      System.out.println(x > 0 && y > 0); // true
      System.out.println(x > 0 || y > 0); // true
      System.out.println(!(x > 0)); // false
    }
  }
}
