package com;

public class Throw1 {

	public static void main(String[] args) {
		//개발자가 예외를 고의적으로 발생 시킬 수 있음
		// 사용하는 키워드 : throw
		
		try {
			//예외 객체 생성
			Exception e = new Exception("고의로 발생시킨 예외");
			throw e; //예외를 던짐(발생시킴), "명령문의 형태," '예외를 던져라'
			// throw new Exception(); //한문장으로도 표현은 가능.
		} catch (Exception e) {
			System.out.println("예외가 발생하였음.");
		}
		System.out.println("프로그램 정상 종료");
	}//main끝

}
