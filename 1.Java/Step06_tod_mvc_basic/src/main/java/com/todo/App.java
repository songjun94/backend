package com.todo;

import java.io.IOException;
import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Todo;

public class App {

	public static void main(String[] args) throws IOException {
		
		
		//controller 생성
		TodoController todoController = new TodoController();
		
		// 전체 Todos 조회
		todoController.findAll();
		
		// 하나의 Todo 결과 조회
		Long todoNumber = 3L;
		todoController.findById(todoNumber);
		
		//하나의 Todo 등록(INSERT)
		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
		todoController.save(newTodo);
		
		//전체 Todos 다시조회
		todoController.findAll();
		
		//하나의 Todo 수정(UPDATE)
//		Long todoNumber = 3L;
		todoController.updateById(todoNumber, new Todo("유튜브", "ted ed를 시청", LocalDate.of(2022, 05, 10)));
		
		//UPDATE 성공여부 확인
		todoController.findById(todoNumber);
		
		todoController.findAll();
		
		//하나의 Todo 삭제 (DELETE)
		todoController.deleteById(todoNumber);
		
		
		
		
}
}
