package dev.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sample.demo.model.Todo;
import dev.sample.demo.service.TodoService;

@RestController
@RequestMapping("api/v1/todos") // localhost:8080/api/v1까지 작서해야 
//TodoController에 접근할 수 있음
@CrossOrigin
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping
	public List<Todo> findAll() {
		//실제 DB에 접근해서 전체 Todo 가져오는 코드 작성
		System.out.println("findAll called!");
		return todoService.findAll();
		
	}
	
	//post 요청, String save() "save() called"

	@PostMapping
	  public Todo save(@RequestBody Todo todo) {
			return todoService.save(todo);
		}
	
	@PutMapping
	public List<Todo> update(@RequestBody Todo todo) {
//		System.out.println(todo);
		
		return todoService.update(todo);
		
	}
	
	@DeleteMapping("/{id}")
	public List<Todo> delete(@PathVariable("id") Long id){
		return todoService.delete(id);
	}
	
	
}
