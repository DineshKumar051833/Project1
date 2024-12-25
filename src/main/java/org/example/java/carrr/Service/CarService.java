package org.example.java.carrr.Service;

import org.example.java.carrr.Entity.Car;
import org.example.java.carrr.Entity.User;
import org.example.java.carrr.Repositary.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public void save(Car car){
        carRepo.save(car);
    }

    public List<Car> returnCars(User user){
        return carRepo.findByUser(user);
    }

    public void delete(Long carId){
        carRepo.deleteById(carId);
    }

}
