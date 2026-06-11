package ex02_dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ex01_db_connect.DBConnect;

// java.sql.pareparedStatement
// 1. 쿼리문을 실행하는 인터페이스
// 2. 미리 쿼리문 컴파일 -> 실행 직전 값 전달
// 3. Placeholder(?) 파라미터 바인딩 지원
// sql injection 방지! - orm쓰면 해결 - orm이 prepared statement 사용

// dml 영향을 받은 행의 갯수 반환 int
public class Main {

  public static void insert() throws Exception {
    Connection conn = DBConnect.getConnection();

    String sql = "INSERT INTO departments(dept_name, location) VALUES (?,?)";

    // 쿼리문 실행 객체 받아오기
    PreparedStatement ps = conn.prepareStatement(sql);

    // 파라미터 바인딩 (?에 값채우기) - 문자열은 자동으로 ''처리
    ps.setString(1, "QA");
    ps.setString(2, "Incheon");

    // 쿼리문 실행하기 - int 타입
    int result = ps.executeUpdate();
    System.out.println(result + "행이 등록되었습니다.");

    // 자원 반납 역순으로 닫기
    if (ps != null)
      ps.close();
    if (conn != null)
      conn.close();

  }

  public static void update() {

    // scope 조정
    Connection conn = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;

    try {
      conn = DBConnect.getConnection();
      conn.setAutoCommit(false); // 현재 커넥션 수동 커밋

      // 트랜잭션 첫번째 작업
      String sql1 = "UPDATE departments SET dept_name = ? WHERE dept_id = ?";
      ps1 = conn.prepareStatement(sql1);
      ps1.setString(1, "개발이뭔지");
      ps1.setInt(2, 5);
      ps1.executeUpdate();

      // 만약 첫번째 작업 이후 예외 발생
      if (Math.random() > 0.0001) {
        throw new SQLException("네트워크 예외 발생");
      }

      // 트랜잭션의 두번째 작업
      String sql2 = "UPDATE departments SET location = ? WHERE location = ?";
      ps2 = conn.prepareStatement(sql2);
      ps2.setString(1, "Seoul");
      ps2.setInt(2, 5);
      ps2.executeUpdate();

      // 커밋 완료
      conn.commit();
      System.out.println("트랜잭션이 성공했습니다.");
    } catch (Exception e) {
      // 예외 발생 시 모든 작업 취소
      if (conn != null) {
        try {
          conn.rollback();
          System.out.println("트랜잭션 롤백");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    } finally {
      // 자원 반납
      try {
        if (conn != null) {
          // 현업 - 커넥션풀에 많이 만들어놓고, 커넥션 주세요해서 사용하고 다시 반납함~
          conn.setAutoCommit(true);
          conn.close();
        }

        if (ps1 != null) {
          ps1.close();
        }

        if (ps2 != null) {
          ps2.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static void delete() throws Exception {
    Connection conn = DBConnect.getConnection();

    String sql = "INSERT INTO departments(dept_name, location) VALUES (?,?)";

    // 쿼리문 실행 객체 받아오기
    PreparedStatement ps = conn.prepareStatement(sql);

    // 파라미터 바인딩 (?에 값채우기) - 문자열은 자동으로 ''처리
    ps.setString(1, "QA");
    ps.setString(2, "Incheon");

    // 쿼리문 실행하기 - int 타입
    int result = ps.executeUpdate();
    System.out.println(result + "행이 등록되었습니다.");

    // 자원 반납 역순으로 닫기
    if (ps != null)
      ps.close();
    if (conn != null)
      conn.close();
  }

  public static void main(String[] args) {
    try {
      update();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
