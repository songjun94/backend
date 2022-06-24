package dev.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sample.demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>  {
		
}
