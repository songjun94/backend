package com.extend;

// A extends B : class A는 class B의 특성을 '재사용' + '확장'
public class Mouse extends Animal{
	// Mouse is an Animal 성립.
	// Mouse는 Animal이다.
	// Animal 클래스가 가진 특성을 물려받을 수 있다. + 자신만의 특성을 확장할 수도 있다.
	// 특성 : 필드와 메서드
	
	private String address;
	
	public Mouse(int age, String color, String address) {

		// age,color 필드는 상위 클래스인 Animal이 가지고 있기 때문에
		// 해당 필드의 초기화는 해당 클래스에게 맡김
		super(age, color); // 상의 클래스의 생성자 호출
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	// 상위 클래스의 메서드(sing()) 재정의(Override)
	// 자신만의 특성에 맞게
//	public void sing() {
//		System.out.println("찍찍!");
//	}
	@Override // 해당 메서드가 overriding 되었다는 것을 의미하는 표기법
	public void sing() {
		System.out.println("찍찍!");
	}

	@Override
	public String toString() {
		return super .getAge() + " " + super.getColor() + " " + address;
		
		
	}
	
}

