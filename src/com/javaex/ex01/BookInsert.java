package com.javaex.ex01;

/************************
0. import java.sql.*;
*************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {
   public static void main(String[] args) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;

      
      try {
    	 /******************************
          1. JDBC 드라이버 (Oracle) 로딩
         *******************************/
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         /**************************
          2. Connection 얻어오기
         ***************************/
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         conn = DriverManager.getConnection(url, "webdb", "webdb");
         
         /****************************
          3. SQL문 준비 / 바인딩 / 실행
         *****************************/
         //query문 준비
         String query = "";
         query += " insert into book (book_id, title, pubs, pub_date, author_id) ";
         query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";
         
         pstmt = conn.prepareStatement(query);
         
         //바인딩
         pstmt.setString(1, "우리들의 일그러진 영웅");
         pstmt.setString(2, "다림");
         pstmt.setString(3, "1998-02-22");
         pstmt.setInt(4, 1);
         
         //실행
         int count = pstmt.executeUpdate();
         
         /*********************
          4.결과처리
         **********************/
         System.out.println(count + "건이 삽입되었습니다.");
         
         //////////////////////////
         //오직두사람/김영하
         //////////////////////////
         
         //바인딩
         pstmt.setString(1, "오직두사람");
         pstmt.setString(2, "문학동네");
         pstmt.setString(3, "2017-05-04");
         pstmt.setInt(4, 6);
         
         //살행
         int count2 = pstmt.executeUpdate();
         
         //결과처리
         System.out.println(count2 + "건이 삽입되었습니다.");
         
      } catch (ClassNotFoundException e) {
         System.out.println("error: 드라이버 로딩 실패 - " + e);
         
      } catch (SQLException e) {
         System.out.println("error:" + e);
         
      } finally {
    	 /*********************
          5. 자원정리
         **********************/
         try {

            if (pstmt != null) {
               pstmt.close();
            }
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            System.out.println("error:" + e);
         }
      }
   }
}