package com.javaex.ex05;

import java.util.ArrayList;

public class BookApp {
	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		ArrayList<BookVo> list;
		
		////////////////
		// INSERT
		////////////////
		
		bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		
		bookDao.bookInsert("삼국지", "민음사", "2002-03-01", 1);
		
		bookDao.bookInsert("토지", "북스", "2020-06-20", 2);
		
		// 출력
		list = bookDao.bookSelect();
		
		for(BookVo bo : list) {
			System.out.println(bo.toString());
		}
		System.out.println("----------------------------");
		
		////////////////
		// UPDATE
		////////////////
		bookDao.bookUpdate("다림출판", "2021-12-29", 5);
		
		// 출력
		list = bookDao.bookSelect();
		
		for(BookVo bo : list) {
			System.out.println(bo.toString());
		}
		System.out.println("----------------------------");
		
		////////////////
		// DELETE
		////////////////
		bookDao.bookDelete(7);
		
		// 출력
		list = bookDao.bookSelect();
		
		for(BookVo bo : list) {
			System.out.println(bo.toString());
		}
		System.out.println("----------------------------");
		
		////////////////
		// SELECT
		////////////////
		// 출력
		list = bookDao.bookSelect();
		
		for(BookVo bo : list) {
			System.out.println(bo.toString());
		}
		System.out.println("----------------------------");
	}
}
