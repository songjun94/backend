package com.overloading;

public class Mouse {
//	 int age, String name
	private int age;
	private String name;
	
	//기본 생성자
	public Mouse() {
	}

	// 나이값만 전달 받는 생성자
	public Mouse(int age) {
		this.age = age;
	}

	//이름만 전달 받는 생성자
	public Mouse(String name) {
		this.name = name;
	}
	
	//나이와 이름을 지정하여 생성하는 생성자
	public Mouse(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public String showMouse() {
		return age + "" + name;
	}
	
}
