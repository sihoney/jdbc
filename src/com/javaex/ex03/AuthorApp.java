package com.javaex.ex03;

import java.util.List;

public class AuthorApp {
	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> list;
		
		//////////////////
		// 삽입
		//////////////////
		
		/********************************    
		 데이터를 주고받을 때는 vo를 이용한다(인자가 두개 이상이라면)  
		*********************************/
		
		AuthorVo vo01 = new AuthorVo("이문열", "경북 양양");
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(vo02);
		
		AuthorVo vo03 = new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(vo03);
		
		// 출력
		System.out.println("----------------------------");
		list = authorDao.authorSelect();
		for(AuthorVo au : list) {
			System.out.println(au.toString());
		}
		System.out.println("-----------------------------");
		
		//////////////////
		// 수정
		//////////////////
		
		AuthorVo authorVo = new AuthorVo(2, "박경리(수정)", "경상남도 통영(수정)");
		authorDao.authorUpdate(authorVo);
		
		// 출력
		System.out.println("----------------------------");
		list = authorDao.authorSelect();
		for(AuthorVo au : list) {
			System.out.println(au.toString());
		}
		System.out.println("-----------------------------");
		
		//////////////////
		// 삭제
		//////////////////
		
		authorDao.authorDelete(1);
		
		// 출력
		System.out.println("----------------------------");
		list = authorDao.authorSelect();
		for(AuthorVo au : list) {
			System.out.println(au.toString());
		}
		System.out.println("-----------------------------");
	}
}
