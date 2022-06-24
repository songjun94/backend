// App.java
package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Mouse;
import com.todo.model.Todo;

public class App {

	// main 메서드
	public static void main(String[] args) {
		
//		Mouse m = new Mouse();
//		m.setName("제리");
//		System.out.println(m);

		
		// 초기 테이블 생성
//		 DBUtils.dropAndCreateTable();
		
		TodoController todoController = new TodoController();
		
		// 전체 Todo 조회(SELECT * FROM todo;)
        todoController.findAll();
	
        // 할일 순서 번호(id)로 하나의 Todo 조회
//        long todoNumber = 2L;
//        todoController.findById(todoNumber);
	
        //하나의 Todo 등록
        Todo todo = new Todo.Builder(null)
        		.title("빵 먹기")
        		.description("소보루빵을 먹는다")
        		.dueDate(LocalDate.of(2022, 05, 22))
        		.build();
        todoController.save(todo);

	}

}
