package com.example.taskmanager.web;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
	TaskService taskService;

	public MainController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		List<Task> tasks = taskService.findAll();
		model.addAttribute("tasks", tasks);
		return "index";
	}
}
