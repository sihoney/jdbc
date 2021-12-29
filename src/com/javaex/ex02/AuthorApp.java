package com.javaex.ex02;

import java.util.ArrayList;

public class AuthorApp {
	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		ArrayList<AuthorVo> authorList;
		
		////////////////
		// INSERT
		////////////////
		authorDao.authorInsert("이문열", "경북 양양");
		
		authorDao.authorInsert("박경리",  "경상남도 통영");
		
		authorDao.authorInsert("유시민", "17대 국회의원");
		
		//출력
		authorList = authorDao.authorSelect();
		for(AuthorVo au : authorList) {
			System.out.println(au.toString());
		}
		System.out.println("----------------------------");
		
		
		////////////////
		// UPDATE
		////////////////
		authorDao.authorUpdate(1, "김문열", "경상북도 영양");
		
		
		////////////////
		// SELECT
		////////////////
		authorList = authorDao.authorSelect();
		for(AuthorVo au : authorList) {
			System.out.println(au.toString());
		}
		System.out.println("----------------------------");
		
		
		////////////////
		// DELETE
		////////////////
		authorDao.authorDelete(2);

		//출력
		authorList = authorDao.authorSelect();
		for(AuthorVo au : authorList) {
			System.out.println(au.toString());
		}
		System.out.println("----------------------------");
	}
}
