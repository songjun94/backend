package com.todo.controller;

import java.nio.file.Path;
import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// 사용자의 요청에 따라 액션을 분기'만' 해주는 역할
		private List<Todo> todos;
		private final TodoView todoView;  //중복제거
		private final TodoService todoService;
		
		public TodoController(List<Todo> todos) {
			this.todos = todos;
			this.todoView = new TodoView(); // 중복제거 아래 두개의 void의 직원호출 
			this.todoService = new TodoService();
		}
		//전체 데이터 조회 처리를 위한 분기
		public void findAll() {
			// todoView야, 사장님(App.java)의 전체 결과값 조회해달래
			todoView.findAll(todos);
		}
		
		//하나의 데이터 조회 처리를 위한 분기
		public void findById(Long id) {
			//todoService에게서 id값으로 찾은 todo 데이터 전달 받음.
			Todo todo = todoService.findById(todos, id);
			
			//todoView야 사장님이 하나의 결과값 조회해달래
			todoView.findById(todo);
		}
		
		public void save(String RESOURCES, Path filePath, Todo newTodo) {
		// 실제 데이터 저장에 대한 처리는 service 클래스가 한다.
		boolean result = todoService.save(RESOURCES, filePath, newTodo);
		System.out.println(result);
		
		//데이터 저장 성공여부는 todoView가 출력한다.
		if(result) {
			todoView.successPage();
		}else {
			todoView.errorPage();
		}
		
		}
}
