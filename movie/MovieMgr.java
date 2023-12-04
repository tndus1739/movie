package com.my.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMgr  {

	int index; 
	MovieMgr (){}
	
	Movie m = new Movie();
	List<Movie> movies = new ArrayList <Movie> () ;

	// 영화 정보 추가
	void add(Movie m) {							 // m : 매개변수
	movies.add(m);
	
	}
	
	// 영화 정보모두 추가
	void search () {
		if (movies.size() > 0) {
			int idx = 1;
			System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
			System.out.println("=================================================");
			for (Movie m : movies) {
				System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, m.getTitle(), m.getDirector(), m.getGrade(), m.getGenre());
			}
			System.out.println();
		} else {
			System.out.println("등록된 영화정보가 없습니다.");
		}
	}
	
	// 영화 제목으로 검색
	void search (String title) {
		if(movies.size() > 0) {
		  int idx = 1 ;
		  for(Movie m : movies) {
			
			if(m.getTitle().equals(title))  {
				System.out.println("=================================================");
				System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, m.getTitle(), m.getDirector(), m.getGrade(), m.getGenre());
			}	
		  }
			if (idx == 1) {
			System.out.println("등록된 영화정보가 없습니다.");
			System.out.println();
			}
		  
	
	   }
		
	}
	
	void searchDirector (String name) {
	int idx = 1 ;
		for(Movie m : movies) {

			if (m.getDirector().equals(name)) {
				System.out.println("=================================================");
				System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, m.getTitle(), m.getDirector(), m.getGrade(), m.getGenre());
			}
		}
	}
	
	// 장르로 영화 검색
	
	List<Movie> searchGenre(String genre) {
		
	List<Movie> li = new ArrayList<>();

		if (movies.size() > 0) {
			for (Movie m : movies) {
				if (m.getGenre().equals(genre) || m.getGenre().contains(genre)) {
					li.add(m);
				}
			}
		}

		return li;
	}

	// 제목으로 영화정보 삭제	
	
	void delete(String title) {
		boolean del = false;
		List<Movie> removed = new ArrayList<>();
		List<String> msg = new ArrayList<>();
		if (movies.size() > 0) {
			for (Movie m : movies) {
				if (m.getTitle().equals(title)) {
					removed.add(m);
					msg.add(m.getTitle());
					del = true;
				}

			}
			
			if (del == false) {
				System.out.println("해당 제목의 영화는 등록되지 않았습니다.");
			} else {
				movies.removeAll(removed);
				System.out.println(msg + " 가 삭제되었습니다.");
			}

		} else {
			System.out.println("아직 등록된 영화가 없습니다.");
		}
	}

}