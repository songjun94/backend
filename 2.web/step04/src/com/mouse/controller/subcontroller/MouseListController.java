package com.mouse.controller.subcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

// Controller 인터페이스를 구현할 구현 클래스
public class MouseListController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list Controller입니다.");
		response.setContentType("text/html;charset=UTF-8");
		
		String path = null;
		
		// Controller -> Service
		MouseService service = MouseService.getInstance(); // 0x100
		
		try {
			ArrayList<Mouse> mouseList = service.mouseList();
			request.setAttribute("list", mouseList);
			
			path = "mouseListView.jsp";
			
		} catch (SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());
			path = "error.jsp";
		}
	
		//실제 페이지 이동
		HttpUtil.forward(request, response, path);
	
	}

}
