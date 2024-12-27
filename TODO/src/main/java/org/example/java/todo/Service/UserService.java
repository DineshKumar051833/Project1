package org.example.java.todo.Service;

import org.example.java.todo.Entity.User;
import org.example.java.todo.Repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void create(User user){
        userRepo.save(user);
    }

    public User getUser(String email){
        return userRepo.findByEmail(email);
    }
}