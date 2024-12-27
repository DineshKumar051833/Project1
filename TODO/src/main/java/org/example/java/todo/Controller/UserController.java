package org.example.java.todo.Controller;

import lombok.Getter;
import org.example.java.todo.Entity.Task;
import org.example.java.todo.Entity.User;
import org.example.java.todo.Service.TaskService;
import org.example.java.todo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService){
        this.userService = userService;
        this.taskService = taskService;
    }

    @Getter
    User currentUser = null;

    @GetMapping("/login")
    public String loginDisplay(){
        return "Login";
    }

    @GetMapping("/signup")
    public String signupDisplay(){
        return "Signup";
    }

    @PostMapping("/signupDetail")
    public String createUser(@RequestParam("username") String name, @RequestParam("email") String email, @RequestParam("password") String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.create(user);
        currentUser = user;
        return "Dashboard";
    }

    @PostMapping("/loginDetail")
    public String user(@RequestParam("email") String email, @RequestParam("password") String password, Model model){
        User user = userService.getUser(email);
        List<Task> list = taskService.getTask(user);
        if (user != null && (user.getPassword().equals(password))){
            model.addAttribute("name",user.getName());
            model.addAttribute("tasks",list);
            currentUser = user;
            return "Dashboard";
        }
        return "Login";
    }

}