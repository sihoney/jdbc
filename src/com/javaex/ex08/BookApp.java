package com.javaex.ex08;

import java.util.ArrayList;
import java.util.Scanner;

import com.javaex.ex03.AuthorDao;
import com.javaex.ex03.AuthorVo;

public class BookApp {
	public static void main(String[] args) {
		
		ArrayList<BookVo> list;		
		
		////////////////
		// 작가 Dao
		////////////////
		AuthorDao authorDao = new AuthorDao();
		
		
		////////////////
		// 작가 추가
		////////////////
		AuthorVo vo01 = new AuthorVo("이문열", "경북 양양");
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(vo02);
		
		AuthorVo vo03 = new AuthorVo("이고잉", "개발 서적 저자");
		authorDao.authorInsert(vo03);
		
		AuthorVo vo04 = new AuthorVo("기안84", "기안동에서 산 84년생");
		authorDao.authorInsert(vo04);
		
		AuthorVo vo05 = new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(vo05);
		
		AuthorVo vo06 = new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(vo06);
		
		////////////////
		// 첵 Dao
		////////////////
		BookDao bookDao = new BookDao();
		
		
		////////////////
		// 책 추가
		////////////////
		BookVo bvo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.bookInsert(bvo01);
		
		BookVo bvo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		bookDao.bookInsert(bvo02);
		
		BookVo bvo03 = new BookVo("토지", "북스", "2020-06-20", 2);
		bookDao.bookInsert(bvo03);
		
		BookVo bvo04 = new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		bookDao.bookInsert(bvo04);
		
		BookVo bvo05 = new BookVo("패션왕", "중앙북스", "2012-02-22", 4);
		bookDao.bookInsert(bvo05);
		
		BookVo bvo06 = new BookVo("순정만화", "재미주의", "2020-06-20", 5);
		bookDao.bookInsert(bvo06);
		
		BookVo bvo07 = new BookVo("오직두사람", "문학동네", "2020-06-20", 6);
		bookDao.bookInsert(bvo07);
		
		BookVo bvo08 = new BookVo("26년", "재미주의", "2020-06-20", 5);
		bookDao.bookInsert(bvo08);
		
		////////////////
		// Scanner 검색어 입력
		////////////////
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색어를 입력하세요.>>");
		
		String search = sc.next();

		sc.close();
		
		////////////////
		// 책 검색 메소드
		////////////////
		list = bookDao.bookSearch(search);
		
		
		////////////////
		// 출력
		////////////////
		for(BookVo bvo : list) {
			System.out.println(bvo.toString());
		}

	}
}
