package org.example.java.carrr.Service;

import org.example.java.carrr.Entity.User;
import org.example.java.carrr.Repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void create(User user){
        userRepo.save(user);
    }

    public User getUser(String email){
        return userRepo.getUserByEmail(email);
    }

}
