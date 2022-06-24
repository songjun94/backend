package com.todo.service;

import java.util.List;

import com.todo.dao.TodoDAO;
import com.todo.model.Todo;

public class TodoService {
	// 비즈니스 로직(Business Logic)을 처리하는 역할
	// 비즈니스 로직 : 해당 애플리케이션에서 중요한 로직을 처리하는 부분
	private final TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO();
		}
	
	//1. 전체 조회 기능 findAll()
	public List<Todo> findAll() {
		//전체 조회 기능은 별도의 비즈니스 로직은 없고 database에 전체 데이터만 가져올수 있도록 dao에 위임 
		//실제 데이터베이스에 접근하는 역할을 하는 별도의 패키지 dao(data access object 데이터 접근 객체 혹은 클래스)
		//결과적으로 findAll은 DB에서 받은 전체 데이터만 반환해주고 있음
		List<Todo> todos = todoDAO.findAll();
		return todoDAO.findAll();
		
	}
	
	// findById : id값에 의해서 일치하는 데이터를 찾는 로직
	// 2. 조회기능2, 할 일 순서 번호로 하나의 Todo 조회 메서드
	public Todo findById(Long id) {
		return todoDAO.findById(id);
	}

	public boolean save(Todo newTodo) {
		return todoDAO.save(newTodo);
	}

	public Todo updateById(Long todoNumber, Todo todo) {
		return todoDAO.updateById(todoNumber, todo);
	}

	public Todo deleteById(Long todoNumber) {
		return todoDAO.deleteById(todoNumber);
	}
}

