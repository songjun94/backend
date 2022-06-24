package com.interfaces.polymorp;
//3번
public class BluntTeeth implements Bitable {

	@Override
	public void bite(String food) {
		System.out.println("난 채식 상어" + food + "냠냠");
	}

}
