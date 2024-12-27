package org.example.java.todo.Controller;

import org.example.java.todo.Entity.Task;
import org.example.java.todo.Entity.User;
import org.example.java.todo.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    private final UserController user;

    public TaskController(TaskService taskService, UserController user){
        this.taskService = taskService;
        this.user = user;
    }

    @PostMapping("/task")
    public String createTask(@RequestParam("description") String description, Model model){
        User currentUser = user.getCurrentUser();
        Task task = new Task();
        task.setDescription(description);
        task.setUser(currentUser);
        taskService.create(task);
        List<Task> list = taskService.getTask(currentUser);
        model.addAttribute("name", currentUser.getName());
        model.addAttribute("tasks", list);
        return "Dashboard";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") Long taskId, Model model){
        User currentUser = user.getCurrentUser();
        taskService.delete(taskId);
        List<Task> list = taskService.getTask(currentUser);
        model.addAttribute("name", currentUser.getName());
        model.addAttribute("tasks", list);
        return "Dashboard";
    }

}