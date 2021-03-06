package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list Controller 입니다.");
	
		// 프론트에서 입력한 데이터 받기(mouseInsert.jsp에서 mouse 등록 폼에 입력한 mouse 정보 추출)
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		// 입력받은 값을 Mouse 객체에 binding
		Mouse mouse = new Mouse();
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		// 비즈니스 로직을 담당하는 Service 객체 생성
		MouseService service = MouseService.getInstance();
		
		
		// 등록 처리용 메서드 int mouseInsert(Mouse mouse) 호출
		int result = service.mouseInsert(mouse);
		
		// 리스트 화면으로 이동하기 위한 경로 작성
		String path = "board?command=list";
		// 실제 이동
		//Bad case(어떤 요청으로 DB에 변화가 생기는 경우에는 새롭게 지정하는 redirect 방식을 사용해야함)
		//forward의 경우에는 request가 유지 되고 있기 때문에 중복 등록됨
//		HttpUtil.forward(request, response, path);
//		2. redirect(recommended)
		HttpUtil.redirect(response, path);

	}

}
