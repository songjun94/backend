package com.mouse.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.subcontroller.MouseInsertController;
import com.mouse.controller.subcontroller.MouseListController;
import com.mouse.controller.subcontroller.MouseReadController;

@WebServlet("/board")
public class FrontController extends HttpServlet{

	HashMap<String, Controller>list = null;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		list.put("list", new MouseListController());
		list.put("insert", new MouseInsertController());
		list.put("read", new MouseReadController());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command는"+command);
		if(command == null) {
			command = "list";
		}
		//command가 "list"일 경우, HashMap의 "list"라는 key의 인스턴스를 얻어옴 (list.get())
//		Controller subController = new MouseListController();로 치환됨
		Controller subController = list.get(command);
		subController.execute(request, response);
	}

	
}
