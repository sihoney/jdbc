package com.javaex.ex01;

/************************
 0. import java.sql.*;
*************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookUpdate {
   public static void main(String[] args) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
    	 /*********************************
          1. JDBC 드라이버 (Oracle) 로딩
         **********************************/
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         /************************
          2. Connection 얻어오기
         *************************/
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         conn = DriverManager.getConnection(url, "webdb", "webdb");
         
         /*****************************
          3. SQL문 준비 / 바인딩 / 실행
         ******************************/
         String query = "";
         query += " update book ";
         query += " set pubs = ?, ";
         query += "     pub_date = ? ";
         query += " where book_id = ? ";
         
         pstmt = conn.prepareStatement(query);
         
         pstmt.setString(1, "다림출판");
         pstmt.setString(2, "2000-02-22");
         pstmt.setInt(3, 9); 
         
         int count = pstmt.executeUpdate();
         
         /*****************
          4.결과처리
         ******************/
         System.out.println(count + "건이 수정되었습니다.");
         
         ////////////////////////////
         
         pstmt.setString(1, "문학도시");
         pstmt.setString(2, "20/05/04");
         pstmt.setInt(3, 10);
         
         int count2 = pstmt.executeUpdate();
         
         System.out.println(count2 + "건이 수정되었습니다.");

         
      } catch (ClassNotFoundException e) {
         System.out.println("error: 드라이버 로딩 실패 - " + e);
         
      } catch (SQLException e) {
         System.out.println("error:" + e);
         

      } finally {
    	 /******************
          5. 자원정리
         *******************/
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