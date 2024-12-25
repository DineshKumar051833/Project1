package org.example.java.carrr.Repositary;

import org.example.java.carrr.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
