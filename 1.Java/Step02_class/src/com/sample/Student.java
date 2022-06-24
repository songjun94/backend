package com.sample;
// 클래스 외부에는 package 선언과 import 문장 외에 아무것도 선언하지 않는다.

//student 클래스 정의
public class Student {

	// 맴버 변수 (맴버 필드): 학생이 가진 속성들 "선언"
	int studentID; // 학번
	String studentName;// 학생이름
	int grade;// 학년
	String address;// 주소, 사는 곳
	
	// 기본 생성자(함수)default Constructor
//	public Student() {
//		System.out.println("Student() 호출");
//		studentName = "톰";
//	}
	public Student() {}
	//학생 이름과 학년을 매개변수로 받는 생성자 작서
	public Student(String studentName, int grade) {
		// 갈색은 지역 변수, 파란색은 맴버 변수
		this.studentName = studentName;
		this.grade = grade;
	}
	// 맴버 메서드 : student(학생)이 할 수 있는 기능, 행위

	// 1. 첫 번째 맴버 메서드: Student(학생)이 할 수 있는 기능, 행위
	// prototype(접근제어자) 반환타입 메서드명() {}
	// void : 반환 타입이 따로 없을 때 사용하는 키워드
	// 현재 showStudent()는 학생의 이름과 주소를 출력만 해주고 있고,
	// 별도의 값(value)을 반환하고 있지는 않음.
	// 왜냐하면 return이라는 키워드가 없기 때문에
	public void showStudent() {
		// 학생의 이름과 주소만 출력해주는 메서드
		System.out.println(studentName + "," + address);
		
	}
	//ctrl shift f 는 코드 정렬

}
