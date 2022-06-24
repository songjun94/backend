package com.extend;


public class App {

	public static void main(String[] args) {
		// Animal 인스턴스 1개 생성
		// anAnimal
		Animal anAnimal = new Animal();
		anAnimal.sing();
		
//		Mouse m = new Mouse();
//		m.setAge(10);
//		m.setColor("갈색");
		
		Mouse jerry = new Mouse(15, "제리", "뉴욕");
		
		jerry.sing(); // jerry야 울어봐

		System.out.println(jerry.toString());
		System.out.println(jerry);
	}

}