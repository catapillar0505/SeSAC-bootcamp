public class VariableEx {

  public static void main(String[] args) {

    // 6가지 기본 타입 (boolean, byte, int, long, double, char)
    boolean hasPen = true;
    byte a = 127;
    int b = 49;
    long c = 10000000000L;
    double d = 1.0;
    char e = 'A';
    System.out.println(hasPen);
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);

    // 문자열 타입 (String)
    String str = "Hello World";
    System.out.println(str);

    // 자동 형 변환
    int n1 = 10;
    long n2 = n1;  // int -> long 자동 형 변환
    System.out.println(n1);
    System.out.println(n2);

    // 강제 형 변환
    // int -> byte 변환
    int i = 256;  //------- 비트값 : 1 0 0 0 0 0 0 0 0
    byte bb = (byte)i;  //-- 비트값 : X 0 0 0 0 0 0 0 0 (상위 비트 손실로 값이 달라짐)
    System.out.println(i);
    System.out.println(bb);

    // double -> long 변환
    double dd = 1.9;
    long l = (long)d;  //-- 실수 -> 정수 변환 시 소수부 아래는 모두 손실
    System.out.println(dd);
    System.out.println(l);

    // int -> char 변환
    int iNum = 48;  //--------- 48('0'), 65('A'), 97('a')
    char ch = (char)iNum;  //-- 정수 -> 문자 변환 시 정수를 코드값으로 가지는 문자로 변환
    System.out.println(iNum);
    System.out.println(ch);
  }

}
