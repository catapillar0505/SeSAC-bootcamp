package ex02_try_catch;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 사용자 입력
        Scanner sc = new Scanner(System.in);

        // 정수 저장할 변수
        int a, b;
        // 무한 루프
        while (true) {
            try {
                // 코드 작성하는 부분
                System.out.println("첫번째 숫자 입력");
                a = sc.nextInt();
                System.out.println("두번째 숫자 입력");
                b = sc.nextInt();

                System.out.println("몫: " + (a / b) + " , 나머지: " + (a % b));

            } catch (ArithmeticException e) {
                // 예외 처리하는 부분
                //System.err.println("예외사유" + e.getMessage());
                //System.err.println("0으로 나눌 수 없습니다. 다시시도하세요");
                e.printStackTrace();
            } catch (InputMismatchException ie) {
                ie.printStackTrace();
            }
        }
    }
}
