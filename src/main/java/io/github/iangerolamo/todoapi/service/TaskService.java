package io.github.iangerolamo.todoapi.service;

import io.github.iangerolamo.todoapi.model.Task;
import io.github.iangerolamo.todoapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task save(Task newTask) {
        return taskRepository.save(newTask);
    }

    public void deleteTask (Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> replaceTask(Task newTask, Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    return taskRepository.save(task);
                });
    }

}
