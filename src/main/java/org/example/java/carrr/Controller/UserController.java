package org.example.java.carrr.Controller;

import org.example.java.carrr.Entity.User;
import org.example.java.carrr.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    User currentUser = null;

    @GetMapping("home")
    public String HomePage(){
        return "Home";
    }

    @GetMapping("login")
    public String LoginPage(){return "Login";}

    @GetMapping("signup")
    public String SignupPage(){
        return "Signup";
    }


    @GetMapping("dashboard")
    public String Dashboard(){
        return "Dashboard";
    }


    @PostMapping("sign")
    public String createUser(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password){
        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.setPassword(password);
        userService.create(user);
        currentUser = user;
        return "Dashboard";
    }

    @PostMapping("log")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password){
        User user = userService.getUser(email);
        if (password.equals(user.getPassword())){
            currentUser = user;
            return "Dashboard";
        }
        return "Login";
    }
}
