package com.my.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieMenu {

	
	MovieMenu (){}
	
	
		
	Scanner sc = new Scanner(System.in);	
	
	MovieMgr mgr = new MovieMgr();
	
	void movieMenu() {
	
	do {	
		System.out.println("=================================================");
		System.out.println("1. 영화 정보 입력");	
		System.out.println("2. 영화 정보 전체 검색");	
		System.out.println("3. 영화명 검색");	
		System.out.println("4. 영화 감독별 검색");	
		System.out.println("5. 영화 장르별 검색");	
		System.out.println("6. 영화 정보 삭제");	
		System.out.println("=================================================");
			
		System.out.println(" 위의 보기 중 하나를 선택하세요.");	
		
		int select = sc.nextInt();
		
		sc.nextLine();
		
		
		switch (select) {
		case 1: 

			Movie mv = new Movie();
			System.out.println("영화 제목을 입력해주세요.");
			mv.setTitle(sc.next());
			System.out.println("영화 감독을 입력해주세요.");
			mv.setDirector(sc.next());
			System.out.println("영화 등급을 입력해주세요.");
			mv.setGrade(sc.nextInt());
			System.out.println("영화 장르를 입력해주세요.");
			mv.setGenre(sc.next());
			
			System.out.println();
			
			mgr.add(mv);
			System.out.println(mv);
			break;
			
			
		case 2: 
			System.out.println("2. 영화 정보 전체 검색");
	
			mgr.search();
			
			break;
		
		
		case 3: 
			 System.out.println("3. 영화명 검색");
			 
			 mgr.search(sc.next());
			break;
		
		case 4: 
			 System.out.println("4. 영화 감독별 검색");
			 mgr.searchDirector(sc.next());
			break;
		
			
		case 5: 
			 System.out.println("5. 영화 장르별 검색");
			 
			 List<Movie> li = new ArrayList<>();
				String ge = sc.next();
				li = mgr.searchGenre(ge);
				
				if (li.size() > 0) {
					int idx = 1;
					System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
					System.out.println("=================================================");
					for (Movie m : li) {
						if (m.getGenre().equals(ge) || m.getGenre().contains(ge)) {
							System.out.printf("%2d. %10s %10s %8d %10s\n", idx++,m.getTitle(), m.getDirector(), m.getGrade(), m.getGenre());
						}
					}
					if (idx == 1) {
						System.out.println("등록된 영화정보가 없습니다.");
					}
					
				} else {
					System.out.println("등록된 영화정보가 없습니다.");
				}
		
			break;	
		
			case 6: System.out.println("6. 영화 정보 삭제");
			System.out.println("삭제할 영화 제목을 입력해주세요.");
			mgr.delete(sc.nextLine());
			
			break;
			case 0 :
			System.out.println("0. 종료");			
			} 
					
	      }while(true);
		
		

		
	}
}

 

	
	

