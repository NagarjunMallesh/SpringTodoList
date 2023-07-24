package com.example.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoList.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long>{

}
