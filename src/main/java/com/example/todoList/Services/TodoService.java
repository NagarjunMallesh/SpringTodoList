package com.example.todoList.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoList.model.Todo;
import com.example.todoList.repository.TodoRepo;

@Service
public class TodoService {
	
	
	@Autowired
	TodoRepo repo;
	

	public List<Todo> getAllTodo(){
		ArrayList<Todo> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
 	}
	
	public Todo getTodoById(Long id){
		return repo.findById(id).get();
	}
	
	public boolean updateTodo(Long id){
		Todo todo = getTodoById(id);
		todo.setStatus("Completed");
		
		return saveTodo(todo);
	}
	
	public boolean saveTodo(Todo todo){
		Todo updated = repo.save(todo);
		
		if(getTodoById(updated.getId())!= null){
			return true;
		}
		return false;
	}
	
	public boolean deleteTodo(Long id){
		repo.deleteById(id);
		
		if(getTodoById(id) == null) {
			return true;
		}
		return false;
	}
}
