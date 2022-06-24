package com.basic;

public class Mouse {
	
	//맴버 필드
	//int age, String name, address, company
	private int age;
	private String name;
	private String address ;
	private String company ;
	
	// 모든 필드를 매개변수로 받는 생성자 작성
	public Mouse(int age, String name, String address, String company) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
		this.company = company;
	}
	
	//setter, getter
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	@Override//generate toString
	public String toString() {
		return "Mouse [age=" + age + ", name=" + name + ", address=" + address + ", company=" + company + "]";
	}

	


	


}
