package io.github.iangerolamo.todoapi.repository;

import io.github.iangerolamo.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
