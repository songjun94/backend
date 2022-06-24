package com.sample;

//App이라는 클래스 정의
public class App {

	// App 클래스가 가진 객체(클래스) 메서드 main()
	// 코드를 실행하면 Eclipse가 내부적으로 main()를 호출함.
	public static void main(String[] args) {
		//main()은? 자바에서는 모든 것들이 함수가 아니라 메서드
		//1. 함수
		//2. 메서드
		
		System.out.println(add(3, 5)); // 자신의 속성이나 메서드는 사용할 수 있다.
	
		//학생 인스턴스 하나 생성
	Student s =	new Student(); //인스턴스	
	
	//현재 s의 상태는 이름도 없고, 학번은 0이고 아무속성도 없는 상태
	s.showStudent();// s 인스턴스가 가진 showStudent()호출.
		
	
	//학생 인스턴스에 속성(필드)을 설정하는 방법
	//1. 생성자 함수(constructor)를 통한 설정
	new Student("톰", 3);
	
	} // main 끝
	
	// 덧셈 기능을 제공하는 메서드, add(), 반환 타입은 int, 파라미터(매개변수)로 a,b를 받음
	public static int add(int a, int b) {
//		int result = a+b;
//		return result;
		return a + b;
	}

}
