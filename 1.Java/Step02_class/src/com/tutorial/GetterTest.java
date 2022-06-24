
// GetterTest.java
package com.tutorial;

public class GetterTest {

	public static void main(String[] args) {
		// Person 인스턴스의 필드값 조회
		// 1. getter()를 통한 필드값 조회
		Person joo = new Person();
		joo.setName("주현영");
		
//		System.out.println(joo.getName());
		
		joo.setAge(20);
//		System.out.println(joo.getAge());
		
		// 생성자 함수를 제외하고,
		// setter()를 호출하지 않아도, 필드값을 설정할 수 있음.
		// getter()를 호출하지 않아도, 필드값에 접근할 수 있음.
		
		Person kwon = new Person();
//		kwon.age = 200; // 우리 프로젝트에서 사람의 나이는 1 ~ 100살까지만 허용이야
//		System.out.println(kwon.getAge());
//		System.out.println(kwon.age);
		kwon.setAge(20);
		
		// 해커가 침입, 권혁수 늙어져라!
		kwon.setAge(200);
		
		System.out.println(kwon.getAge()); // 실패 ㅠㅠ
	}

}