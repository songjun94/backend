package com;

public class MethodEx1 {

	//MethodEx1의 맴버 메서드
	public static void main(String[] args) throws Exception{
		method1();
	}

	//MethodEx1의 맴버 메서드 2
	static void method1() throws Exception{
			method2();
		System.out.println("method1() 호출");
	}
	
	//MethodEx1의 맴버 메서드 3
	static void method2() throws Exception { // method2()내부에서 예외가 발생하면,
		// 해당 예외에 대한 예외 처리를 method2()를 호출한 호출부에서 처리하도록 책임을 떠넘김.
//		throw new Exception("예외를 고의로 발생시킴");
		System.out.println(3/0);// 다 throws Exception으로 하면 오류가 안떠도 실행이 안됨
	}
	
		
	
}
