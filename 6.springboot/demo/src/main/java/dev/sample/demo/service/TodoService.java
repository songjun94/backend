package dev.sample.demo.service;

import java.util.List;

import dev.sample.demo.model.Todo;


public interface TodoService {
	List<Todo> findAll();

	Todo save(Todo todo);

	List<Todo> update(Todo todo);

	List<Todo> delete(Long id);
}
