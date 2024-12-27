package org.example.java.todo.Service;

import org.example.java.todo.Entity.Task;
import org.example.java.todo.Entity.User;
import org.example.java.todo.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public void create(Task task){
        taskRepo.save(task);
    }

    public void delete(Long id){
        taskRepo.deleteById(id);
    }

    public List<Task> getTask(User user){
        return taskRepo.findByUser(user);
    }
}