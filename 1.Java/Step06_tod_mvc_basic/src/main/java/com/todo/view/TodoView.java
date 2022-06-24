package com.todo.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.todo.model.Todo;

public class TodoView {
	//실제 결과값 출력을 담당하는 역할
	
	// 1. 전체 조회 결과 출력
	public void findAll(List<Todo> todos) {
		System.out.println("전체 조회 결과입니다. 사장님");
		for (Todo todo : todos) {
			System.out.println(String.format("%d 번째로 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
		      System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
		      System.out.println();
		}
		
	}
	//2. 하나의 조회 결과 출력
	public void findById(Todo todo) {
		System.out.println("하나의 데이터 조회 결과입니다. 사장님");
		System.out.println(String.format("%d 번째로 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
	      System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
	      System.out.println();
	}
	
	//3. 등록 처리 여부 결과 출력
	public void successPage() {
		System.out.println("정상등록 되었습니다.");
	}
	
	//4. 에러 결과 출력
	public void errorPage() {
		System.out.println("문제가 발생하였습니다.");
	}
	
	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다."+ error.getMessage());
	}
	public void update(Todo previousTodo) {
		System.out.println("정상수정되었다.");
		System.out.println("수정되기 이전 값:" + previousTodo);
	}
	public void delete(Todo deletedTodo) {
		System.out.println("정상삭제되었다.");
		System.out.println("삭제되기 이전 값:" + deletedTodo);
	}
	
	
}
