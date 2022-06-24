package com.polymorphism2;

public class App {

	public static void main(String[] args) {
		//Animal 타입의 참조변수 animal로 Whale 타입의 인스턴스 생성
		Animal animal = new Whale();
		animal.name = "Animal 타입으로";
		
		animal.sing();
		
		Whale whale = new Whale();
		whale.name = "Whale 타입으로";
		whale.sing();
		
		animal.swim(); 
		//상위 타입의 참조변수로는 하위 타입의 맴버 사용 불가.
		
		whale.swim();
		//반대도 가능할까?
		Whale w = new Animal();
	}

}
