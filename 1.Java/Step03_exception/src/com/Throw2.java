package com;

public class Throw2 {

	public static void main(String[] args) throws Exception {
		throw new Exception("이러면 어떡함?"); //컴파일도 안된다. 컴파일 오류, checkedException
		
//		throw new RuntimeException("이건 컴파일 됨");// uncheckedException
//		System.out.println("프로그램 종료");
	}

}
