package com.javaex.ex07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex01.Book;
import com.javaex.ex01.BookAuthor;

public class BookDao {

	/////////////////////
	// field
	/////////////////////
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	
	/////////////////////
	// constructor
	/////////////////////
	public BookDao() {
		
	}
	
	/////////////////////
	// method
	/////////////////////
	public void bookInsert(BookVo bookVo) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      
	      try {
	    	 /******************************
	          1. JDBC 드라이버 (Oracle) 로딩
	         *******************************/
	         Class.forName(driver);
	         
	         /**************************
	          2. Connection 얻어오기
	         ***************************/
	         conn = DriverManager.getConnection(url, id, pw);
	         
	         /****************************
	          3. SQL문 준비 / 바인딩 / 실행
	         *****************************/
	         //query문 준비
	         String query = "";
	         query += " insert into book (book_id, title, pubs, pub_date, author_id) ";
	         query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";
	         
	         pstmt = conn.prepareStatement(query);
	         
	         //바인딩
	         pstmt.setString(1, bookVo.getTitle());
	         pstmt.setString(2, bookVo.getPubs());
	         pstmt.setString(3, bookVo.getPubDate());
	         pstmt.setInt(4, bookVo.getAuthorId());
	         
	         //실행
	         int count = pstmt.executeUpdate();
	         
	         /*********************
	          4.결과처리
	         **********************/
	         System.out.println(count + "건이 삽입되었습니다.");

	         
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
	
	public void bookUpdate(BookVo bookVo) {
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	    	 /*********************************
	          1. JDBC 드라이버 (Oracle) 로딩
	         **********************************/
	         Class.forName(driver);
	         
	         /************************
	          2. Connection 얻어오기
	         *************************/
	         conn = DriverManager.getConnection(url, id, pw);
	         
	         /*****************************
	          3. SQL문 준비 / 바인딩 / 실행
	         ******************************/
	         String query = "";
	         query += " update book ";
	         query += " set pubs = ?, ";
	         query += "     pub_date = ? ";
	         query += " where book_id = ? ";
	         
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setString(1, bookVo.getPubs());
	         pstmt.setString(2, bookVo.getPubDate());
	         pstmt.setInt(3, bookVo.getBookId()); 
	         
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
	
	public void bookDelete(int bookId) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	    	 /******************************
	          1. JDBC 드라이버 (Oracle) 로딩
	         *******************************/
	         Class.forName(driver);
	         
	         /******************************
	          2. Connection 얻어오기
	         *******************************/
	         conn = DriverManager.getConnection(url, id, pw);
	         
	         /*****************************
	          3. SQL문 준비 / 바인딩 / 실행
	         ******************************/
	         String query = "";
	         query += " delete from book ";
	         query += " where book_id = ?";
	         
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setInt(1, bookId);
	         
	         int count = pstmt.executeUpdate();
	         
	         /******************
	         4.결과처리
	         *******************/
	         System.out.println(count + "건이 삭제되었습니다.");
	         
	      } catch (ClassNotFoundException e) {
	         System.out.println("error: 드라이버 로딩 실패 - " + e);
	         
	      } catch (SQLException e) {
	         System.out.println("error:" + e);
	         
	      } finally {
	    	  /***************
	          5. 자원정리
	          ****************/
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
	
	public ArrayList<BookVo> bookSelect() {
		
		ArrayList<BookVo> aList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
			
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select book_id, ";
			query += " 		  title, ";
			query += " 		  pubs, ";
			query += " 		  pub_date ";
			query += " from book ";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
		
			// 4.결과처리
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				
				aList.add(new BookVo(bookId, title, pubs, pubDate));
			}

			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
			
		} finally {
			// 5. 자원정리
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
