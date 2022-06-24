package com.todo.mvc;

public class BookTest {

	public static void main(String[] args) {
		// 길이가 3인 정수형 배열
		int[] numbers = new int[3];
		// 길이가 3인 문자열 배열
		String[] names = new String[3];

		//길이가 3인 Book타입의 객체배열
		Book[] books = new Book[3];
	
		Book book1 = new Book("노인과 바다", "헤밍웨이");
		System.out.println(book1);
		System.out.println(book1.getBookname());
	
		books[0] = book1;
		System.out.println(books[0]);
		
		books[1] = new Book("자바의 정석", "남궁성");
		books[2] = new Book("다큰 왕자", "생텍쥐페리");
		
		for (Book book : books) {
			System.out.println(book.getBookname()+""+book.getAuthor());
	
		}
	}

}
