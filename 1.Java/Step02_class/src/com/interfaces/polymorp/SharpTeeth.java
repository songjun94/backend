package com.interfaces.polymorp;
//2번
public class SharpTeeth implements Bitable {

	@Override
	public void bite(String food) {
		System.out.println("나는 육식 상어" + food + "우걱우걱");
	}

}
