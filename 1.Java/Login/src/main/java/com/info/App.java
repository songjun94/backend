// App.java
package com.info;


import com.info.controller.InfoController;
import com.info.model.Info;

public class App {

	// main 메서드
	public static void main(String[] args) {
		
		InfoController infoController = new InfoController();
		
		// 전체 Todo 조회(SELECT * FROM info;)
        infoController.findAll();
	
        Info info = new Info.Builder(null)
        		.name("ABC")
        		.age(20L)
        		.gender("F")
        		.address("Seoul")
        		.phone("010-1234-5678")
        		.id("ididid")
        		.password(1234L)
        		.build();
        infoController.save(info);

	}

}
