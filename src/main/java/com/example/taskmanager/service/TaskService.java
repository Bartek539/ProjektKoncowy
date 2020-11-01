package com.example.taskmanager.service;


import com.example.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    Task save (Task task);
    List<Task> findAll();
    void deleteById(Long id);
}
