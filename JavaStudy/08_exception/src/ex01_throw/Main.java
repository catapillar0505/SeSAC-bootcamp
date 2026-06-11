package ex01_throw;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    // try with resources: 자동으로 close 처리합니다
    // try (자원 생성) { } catch() {}
    try (Scanner sc = new Scanner(System.in);) {
      System.out.println("점수 입력 (0~100)");
      int score = sc.nextInt();

      if (score < 0 || score > 100) {
        throw new RuntimeException(score + "점은 0~100 사이 점수가 아닙니다");
      }

      System.out.println(score >= 60 ? "합격" : "불합격");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } 
    /*finally {
      sc.close();
    }*/


  }
}
