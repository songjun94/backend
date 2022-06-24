package com.interfaces.basic;

//Calc 인터페이스를 구현할 '구현 클래스(구현체)' CompleteCalc
public class CompleteCalc implements Calc { // Calc 인터페이스는 계산을 '~할수 있는(~able)'
	// Calc 인터페이스를 구현하기 위해서는 명시해야함
		// CompleteCalc implements Calc : CompleteCalc 클래스는 Calc 인터페이스를 구현하겠다 라고 명시
	
	@Override
	//Calc 인터페이스의 추상 메서드 add()를 구현
	public int add(int a, int b) {
		return a+b; // 코드를 구현
	}

	@Override
	//Calc 인터페이스의 추상 메서드 substract()를 구현
	public int substract(int a, int b) {
		return a-b;
	}

}

