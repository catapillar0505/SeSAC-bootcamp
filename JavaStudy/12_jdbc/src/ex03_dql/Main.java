package ex03_dql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.sql.ResultSet;

import ex01_db_connect.DBConnect;

public class Main {
  // 부서 목록 반환
  public static List<Department> findDepartments() throws Exception {
    List<Department> departments = new ArrayList<>();

    Connection conn = DBConnect.getConnection();

    // + 연산자 대신 APPEND 쓰는 이유 - 성능 이슈
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT dept_id, ");
    sb.append("dept_name,");
    sb.append("location ");
    sb.append("FROM departments ");
    sb.append("LIMIT 0, 10");
    String sql = sb.toString();

    PreparedStatement ps = conn.prepareStatement(sql);

    ResultSet rs = ps.executeQuery();

    while (rs.next()) { // next 다음행이 있을때만 실행
      Department dept = Department.builder()
          .deptId(rs.getInt("dept_id"))
          .deptName(rs.getString("dept_name"))
          .location(rs.getString("location"))
          .build();

      departments.add(dept);
    }
    // 역순으로 자원 반납
    if (rs != null)
      rs.close();
    if (ps != null)
      ps.close();
    if (conn != null)
      conn.close();

    return departments;
  }

  // 부서 수 반환 메서드
  public static int getDepartmentsCount() throws Exception {
    Connection conn = DBConnect.getConnection();
    String sql = "SELECT COUNT(*) AS dept_count FROM departments";

    PreparedStatement ps = conn.prepareStatement(sql);

    ResultSet rs = ps.executeQuery(); // SQL SELECT 쿼리를 실행하면 반환되는 테이블 형태의 데이터 집합
    int deptCount = 0;
    if (rs.next()) { // // 다음 행으로 이동, 없으면 false
      deptCount = rs.getInt("dept_count");
      System.out.println(deptCount + "개 부서가 조회되었습니다");
    }

    // 역순으로 자원 반납
    if (rs != null)
      rs.close();
    if (ps != null)
      ps.close();
    if (conn != null)
      conn.close();

    return deptCount;
  }

  public static void main(String[] args) {
    try {
      int deptCount = getDepartmentsCount();
      System.out.println("받아온 부서 수: " + deptCount);

      List<Department> departments = findDepartments();

      departments.stream()
        .forEach(d -> System.out.println(d));
        // .forEach(Stystem.out::println)
      
      Gson gson = new Gson();
      String jsonResult = gson.toJson(departments);
      System.out.println(jsonResult);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
