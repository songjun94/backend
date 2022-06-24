package com.interfaces.polymorp;
//5번
public class TeethShop {
	public static Bitable getTeeth(String food) {
//		Bitable b = new SharpTeeth();가 되니까
		if(food.equals("채식")) {
			return new BluntTeeth();
		}else {
			return new SharpTeeth();
		}
	}
}
	
