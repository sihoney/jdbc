// Dao --> Vo --> 공통 변수 빼기

package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/****************************
0. import java.sql.*;
*****************************/

public class AuthorDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	
	public AuthorDao() {
		
	}
	
	public void authorInsert(AuthorVo authorVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/********************************
			 1. JDBC 드라이버 (Oracle) 로딩
			*********************************/
			Class.forName(driver);
			
			/*****************************
			2. Connection 얻어오기
			******************************/
			conn = DriverManager.getConnection(url, id, pw);
			
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
	         //문자열 만들기 --> ? 주의
	         String query = ""; 
	         // query += query + "문자열"
	         query += " insert into author ";
	         query += " values(seq_author_id.nextval, ?, ?) ";
	               
	         // 문자열 쿼리문으로 만들기
	         pstmt = conn.prepareStatement(query);
	               
	         
	         //바인딩
	         pstmt.setString(1, authorVo.getAuthorName()); // 첫번째 물음표에 해당
	         pstmt.setString(2, authorVo.getAuthorDesc()); // 두번째 물음표에 해당
	         
	         //실행
	         int count = pstmt.executeUpdate(); // 쿼리문 실행
			
	        /*****************
			 4.결과처리
			******************/
	         System.out.println(count + "건이 저장되었습니다.");
			
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
	
	public void authorUpdate(AuthorVo authorVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/********************************
			 1. JDBC 드라이버 (Oracle) 로딩
			*********************************/
			Class.forName(driver);
			
			/*****************************
			2. Connection 얻어오기
			******************************/
			conn = DriverManager.getConnection(url, id, pw);
			
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
	         // 문자열 만들기
	         String query = "";
	         query += " update author ";
	         query += " set author_name = ?, ";
	         query += "       author_desc = ? ";
	         query += " where author_id = ? ";
	         
	         // 문자열을 쿼리문으로 만들기
	         pstmt = conn.prepareStatement(query);
	         
	         // 바인딩
	         pstmt.setString(1, authorVo.getAuthorName());
	         pstmt.setString(2, authorVo.getAuthorDesc());
	         pstmt.setInt(3, authorVo.getAuthorId());
	         
	         int count = pstmt.executeUpdate();
	         
			
	        /*****************
			 4.결과처리
			******************/
	         System.out.println(count + "건이 수정되었습니다.");
			
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

	
	public void authorDelete(int authorId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/********************************
			 1. JDBC 드라이버 (Oracle) 로딩
			*********************************/
			Class.forName(driver);
			
			/*****************************
			2. Connection 얻어오기
			******************************/
			conn = DriverManager.getConnection(url, id, pw);
			
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
	         String query = "";
	         query += " delete from author ";
	         query += " where author_id = ? ";
	         
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setInt(1, authorId);
	         
	         int count = pstmt.executeUpdate();
			
	        /*****************
			 4.결과처리
			******************/
	         System.out.println(count + "건이 삭제되었습니다.");
			
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
	
	public ArrayList<AuthorVo> authorSelect() {
		
		ArrayList<AuthorVo> aList = new ArrayList<AuthorVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/********************************
			 1. JDBC 드라이버 (Oracle) 로딩
			*********************************/
			Class.forName(driver);
			
			/*****************************
			2. Connection 얻어오기
			******************************/
			conn = DriverManager.getConnection(url, id, pw);
			
			/*****************************
			 3. SQL문 준비 / 바인딩 / 실행
			******************************/
			String query = "";
			query += " select author_id id, ";
			query += " 		  author_name, ";
			query += " 		  author_desc ";
			query += " from author ";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			/***************
			 4.결과처리
			****************/
			while(rs.next()) {
				/*
				int authorId = rs.getInt("id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				*/
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				
				aList.add(new AuthorVo(authorId, authorName, authorDesc));

			}

			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
			
		} finally {
			/***************
			 5. 자원정리
			****************/
			try {
				
				if (rs != null) {
					rs.close();
				}
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
		return aList;
	}
}
