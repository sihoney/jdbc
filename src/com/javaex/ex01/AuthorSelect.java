package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/************************
 0. import java.sql.*;
*************************/
public class AuthorSelect {
	public static void main(String[] args) {

		ArrayList<Author> aList = new ArrayList<Author>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/*******************************
			 1. JDBC 드라이버 (Oracle) 로딩
			********************************/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/****************************
			 2. Connection 얻어오기
			*****************************/
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
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
				
				aList.add(new Author(authorId, authorName, authorDesc));
				
				System.out.println(authorId + ", " + authorName + ", " + authorDesc);
			}
			
			// 출력
			System.out.println();
			for(Author au : aList) {
				System.out.println(au.toString());
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
	}
}
