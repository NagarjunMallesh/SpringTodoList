package com.example.todoList.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.todoList.Services.TodoService;
import com.example.todoList.model.Todo;

@Controller
public class TodoController {
	
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping("/todoList/viewAllTodoLists")
	public String viewAllTodoLists(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", todoService.getAllTodo());
		model.addAttribute("message", message);
		
		System.out.println("sample printing");
		
		return "ViewTodo"; 
	}
	
	@PostMapping("/todoList/updateTodoItem/{id}")
	public String updateTodoItem(@PathVariable Long id, RedirectAttributes redirectAttribute) {
		if(todoService.updateTodo(id)) {
			redirectAttribute.addFlashAttribute("message","Update Successfull");
			return "redirect:/todoList/viewAllTodoLists";
			}
		redirectAttribute.addFlashAttribute("message","Update Failure");
		return "redirect:/todoList/viewAllTodoLists";
		}
	
	@GetMapping("/todoList/addTodoItem")
	public String addTodoItem(Model model) {
		model.addAttribute("todo", new Todo());
		return "AddTodoItem";
	}
	
	@PostMapping("/todoList/saveTodoItem")
	public String saveTodoItem(Todo todo, RedirectAttributes redirectAttributes) {
		if(todoService.saveTodo(todo)) {
			redirectAttributes.addFlashAttribute("message","Save Success!!");
			return "redirect:/todoList/viewAllTodoLists";
		}
		redirectAttributes.addFlashAttribute("message","Save Failure!!");
		return "redirect:/todoList/viewAllTodoLists";
	}
	
	@GetMapping("/todoList/editTodoItem/{id}")
	public String editTodoItem(@PathVariable Long id, Model model) {
		model.addAttribute("todo",todoService.getTodoById(id));
		return "EditToDoItem";
	}
	
	@PostMapping("/todoList/saveEditTodoItem")
	public String saveEditTodoItem(Todo todo, RedirectAttributes redirectAttributes) {
		if(todoService.saveTodo(todo)) {
			redirectAttributes.addFlashAttribute("message","Edit Success!!");
			return "redirect:/todoList/viewAllTodoLists";
		}
		redirectAttributes.addFlashAttribute("message","Edit  Failure!!");
		return "redirect:/todoList/viewAllTodoLists";
	}
	
	@GetMapping("/todoList/deleteTodoItem/{id}")
	public String deleteTodoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(todoService.deleteTodo(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success!!");
			return "redirect:/todoList/viewAllTodoLists";
		}
		
		redirectAttributes.addFlashAttribute("message", "Delete Failure!!");
		return "redirect:/todoList/viewAllTodoLists";
		
	}
	
}
