package ex01_db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1. java.sql.connection
// db와의 연결 = 세션 관리하는 인터페이스
// db 연결 트랜잭션

// 2. java.sql.drivermanager
// 커넥션을 반환하는 클래스

public class DBConnect {
  // 클래스 메서드
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

      // 드라이버 클래스 로드
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1:3306/company_db?serverTimeZone=UTC&characterEnconding=UTF-8",
        "root",
        "1234"
      );

      return conn;
  }
}
