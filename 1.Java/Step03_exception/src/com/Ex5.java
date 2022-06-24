package com;

public class Ex5 {

	public static void main(String[] args) {
		int[] index = {1,2,3};
		
		for(int i = 0 ; i < 5 ; i++) try {
			System.out.println(index[i]);
		}catch(Exception e) {
			System.out.println("출력할 수 있는 범위를 초과했습니다.");
			e.printStackTrace();
		}

	}

}
