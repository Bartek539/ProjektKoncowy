package com.example.taskmanager.web;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
	TaskService taskService;
	UserService userService;

	public MainController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/table")
	public String home(Model model) {
		List<Task> tasks = taskService.findAll();
		model.addAttribute("tasks", tasks);
		return "tables";
	}
	@GetMapping("/")
	public String table(Model model, Principal principal) {
		User user = userService.findUserByEmail(principal.getName());
		List<Task> tasks = taskService.findAllByUser(user);
		model.addAttribute("tasks", tasks);
		return "index";
	}
}
