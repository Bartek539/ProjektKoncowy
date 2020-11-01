package com.example.taskmanager.web;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class TaskController {
    TaskService taskService;
    UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/add")
    String saveTest(Task task, Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        task.setUser(user);
        taskService.save(task);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String home(Model model) {
        model.addAttribute("Task", new Task());
        return "addtask";
    }
    @GetMapping("/delete/{id}")
    String deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return "redirect:/";
    }
}
