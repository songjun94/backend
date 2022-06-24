package com.todo.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;

// 가상의  Database 공간
public class TodoDatabase {
	
	// 맴버 필드
	// Todo 데이터를 보관할 컬렉션 변수
	// Todo 타입만 받을 수 있는 List 인터페이스
	private static List<Todo> todoDatabase = new ArrayList<>();

	//static block, 프로글매이 실행될 때 한 번만 수행됨
	{
		System.out.println("static block 호출");
		todoDatabase.add(new Todo(1L, "숙제하기", LocalDate.of(2022, 4, 5), "수학, 영어 숙제"));
		todoDatabase.add(new Todo(2L, "조깅하기", LocalDate.of(2022, 5, 7), "공원에서 1시간 동안 조깅을 한다."));
		todoDatabase.add(new Todo(3L, "빨래하기", LocalDate.of(2022, 4, 4), "빨래를 모아서 세탁기를 돌린다."));
		todoDatabase.add(new Todo(4L, "피아노", LocalDate.of(2022, 4, 7), "학원에서 피아노를 연습한다"));
		todoDatabase.add(new Todo(5L, "강아지 밥주기", LocalDate.of(2022, 4, 7), "강아지에게 사료를 준다."));
	}
	
	public static List<Todo> getTodos() {
		return todoDatabase;
	}

	public Todo findById(Long id) {
		//DB상에서 id값과 일치하는 데이터를 찾는 처리를 Java 코드로 표현
		for (Todo todo : todoDatabase) {
			if(todo.getId() == id) {
				return new Todo(todo.getId(), todo.getTitle(), todo.getDueDate(), todo.getDescription());
			}
		}
		return null;
	}

	//insert todo data
	public boolean save(Todo newTodo) {
		//다음 번호값  : 요소의 길이 파악 +1L
		Long nextIndex = todoDatabase.size() + 1L;
		//new Todo의 id 필드에 다음 번호값
		newTodo.setId(nextIndex);
		//todoDatabase list에  newTodo추가
	 return	todoDatabase.add(newTodo); // add반환타입 boolean
	}

	public Todo updateById(Long todoNumber, Todo newTodo) {
		newTodo.setId(todoNumber + 1L);
		
		for (Todo todo : todoDatabase) {
			if(todo.getId() == todoNumber) {//DB의 데이터에 존재하는 id와 todoNumber가 동일할때
				return todoDatabase.set(todoNumber.intValue(), newTodo);
			}
		}
		return null;
	}

	public Todo deleteById(Long todoNumber) {
		for (Todo todo : todoDatabase) {
			if(todo.getId() == todoNumber) {
			return todoDatabase.remove(todoNumber.intValue());
			}
		}
		return null;
	}
	
	
}
