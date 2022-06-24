package com.overriding;

public class App {

	public static void main(String[] args) {
	Animal someAnimal =	new Animal();
	someAnimal.name = "어떤동물";
	someAnimal.showName();
	System.out.println();
	
	Mouse jerry = new Mouse();
	jerry.name = "제리";
	jerry.address ="하와이";
	
	jerry.showName(); // 내이름은 비밀이야
	
	jerry.showName("톰"); // String yourName 톰 안녕, 나는 제리야
	
	// 다형성
	Animal anAnimal =new Animal();
	Mouse jay = new Mouse();
	
	Animal mickey = new Mouse(); //하위 Mouse 타입의 인스턴스를 상위Animal 타입의 참조 변수에 대입
	
	mickey.name = "미키마우스";
	//mickey.address = "롯데타워"; // 상위 타입의 참조변수(Animal mickey)로 하위 타입(address)의 맴버 사용 불가
	
	mickey.showName(); // mickey는 상위 타입(Animal)의 참조 변수지만, 오버 라이딩 되었기 때문에 예외적으로 사용가능
	
	
//	mickey.showAddr(); // 상위 타입의 참조변수(Animal mickey)로 하위 타입의 맴버(showAddr())로 사용(접근) 불가.
	}

}
