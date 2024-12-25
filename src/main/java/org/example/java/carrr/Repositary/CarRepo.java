package org.example.java.carrr.Repositary;

import org.example.java.carrr.Entity.Car;
import org.example.java.carrr.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findByUser(User user);
}
