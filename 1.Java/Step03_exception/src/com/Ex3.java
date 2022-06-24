package com;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(2.5); 
			System.out.println(3/0); // 예외가 발생해서, 에외 인스턴스(new ArithmeticException())가 생성되는 부분
			System.out.println(3); // 10번라인에서 예외가 발생했기 때문에 catch block으로 이동하게 되고 , 3은 출력되지 않는다.
		} catch (Exception e) {
			//코드를 자유롭게 작성 가능한 부분
			if (e instanceof ArithmeticException) {
			System.out.println(e instanceof ArithmeticException);
//			참조변수 exception 내부에 들어 있는 실제 인스턴스가 ArithmeticException 클래스의 인스턴스인지 확인하는 연산자
//			실제 인스턴스가 ArithmeticException이면 해당 조건식의 결과값은 true 아니면 false
			
			System.out.println(e instanceof NullPointerException); //false
		//			System.out.println("true");
		// 만약 catch(ArithmeticExceptionException e)이렇게 쓰면 16번 오류남
		
		}
		System.out.println(4);
	}// try catch 끝
    System.out.println(5);
  }//main끝	
}
