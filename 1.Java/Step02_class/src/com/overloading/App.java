package com.overloading;

public class App {

	public static void main(String[] args) {
		// 생성자를 활용하여 쥐 인스턴스 생성
		
		//0. 디폴트 생성자로 생성
	   Mouse jerry = new Mouse();
		System.out.println(jerry.age);
		System.out.println(jerry.name);
		
	   //1.나이만 초기화해서 생성
		Mouse jay = new Mouse(15);
	   System.out.println(jay.age);
	   System.out.println(jay.name);
		
	    //2. 이름만 초기화해서 생성
	   Mouse jamie = new Mouse("제이미");
	   System.out.println(jamie.age);
	   System.out.println(jamie.name);		
		
	    //3. 나이와 이름을 한번에 지정하여 생성 (매개변수 순서)
		Mouse joo = new Mouse(5, "주");
		System.out.println(joo.age);
		System.out.println(joo.name);
		
	}

}
