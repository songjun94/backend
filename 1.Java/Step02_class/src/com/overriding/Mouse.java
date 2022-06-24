package com.overriding;
                
public class Mouse extends Animal {
	public String address;
	
	public void showAddr() {
		System.out.printf("%s는%d에 살아", name, address);
	}
	
	//오버라이딩 - 재정의 : 상위 클래스의 메서드와 '같은' 메서드 이름 '같은' 인자 리스트
	public void showName() {
		System.out.println("내이름은 비밀인데");
	}
	
	//오버로딩 - 이미 있는 showName 메서드를 인자 값이 다르게 하기 때문에 중복정의: '같은' 메서드 이름, '다른' 인자리스트 상위 클래스와 관련이 없다.
	public void showName(String yourName) {
		System.out.printf("%s 안녕 나는 %s야\n", yourName, name);
	
	
	
	}
}
