package org.example.java.todo.Repository;

import org.example.java.todo.Entity.Task;
import org.example.java.todo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
