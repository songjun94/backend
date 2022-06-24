// SetterTest.java
package com.tutorial;

public class SetterTest {

	public static void main(String[] args) {
		// 학생 인스턴스에 속성(필드)을 설정하는 방법
		// 2. setter()를 통한 필드 값 설정, setting을 해주는 사람(er) => setter
		
		// 디폴트 생성자로 Person 인스턴스 1개 생성
		Person park = new Person();
		park.setName("린킨박");
		
		// 린킨박의 나이를 20살로 설정
		park.setAge(20);
		
		// 멤버 메서드 호출
		System.out.println(park.showPerson());
		
	}

}