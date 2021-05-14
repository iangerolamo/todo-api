package io.github.iangerolamo.todoapi.controller;

import io.github.iangerolamo.todoapi.model.Task;
import io.github.iangerolamo.todoapi.repository.TaskRepository;
import io.github.iangerolamo.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    TaskRepository taskRepository;
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("tasks")
    Task save(@RequestBody Task newTask) {
        return taskService.save(newTask);
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("tasks/{id}")
    Optional<Task> replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return taskService.replaceTask(newTask, id);
    }


}
