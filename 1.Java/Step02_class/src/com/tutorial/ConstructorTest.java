// ConstructorTest.java
package com.tutorial;

public class ConstructorTest {

	public static void main(String[] args) {
		/** App.java 기준, App 클래스 기준에서는
		 *  Person.java(Person class)는 다른 객체
		 *  사용하기 위해서는 인스턴스를 생성해야 한다.
		 */
		// 학생 인스턴스에 속성(필드)을 설정하는 방법
		// 1. 생성자 함수(constructor)를 통한 필드 값을 설정
		Person tom = new Person("톰", 2);
		System.out.println(tom.showPerson());
		
		Person jerry = new Person("제리", 95);
		System.out.println(jerry.showPerson());
		
		// 서로 같지 않다. 인스턴스는 고유하기 때문에.
		System.out.println(tom == jerry);
		
		System.out.println(tom);
		System.out.println(jerry);
		
		// 기본 생성자로 인스턴스를 생성하려면?
		Person sombody = new Person();
	}

}

