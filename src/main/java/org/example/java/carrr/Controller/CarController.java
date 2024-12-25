package org.example.java.carrr.Controller;

import org.example.java.carrr.Entity.Car;
import org.example.java.carrr.Entity.Cars;
import org.example.java.carrr.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class CarController {

    @Autowired
    CarService service;

    @Autowired
    UserController userController;

    public static List<Cars> list = new ArrayList<>();


    Cars cars;

    public static void addCars(){
        list.add(new Cars(1,"https://i.pinimg.com/736x/4a/1e/20/4a1e203b20a6983f5b08977a56250f8c.jpg","Toyoto1",5000001));
        list.add(new Cars(2,"https://i.pinimg.com/236x/65/48/a5/6548a5a40e1f5ede3f550396e9b9e884.jpg","Toyoto2",5000002));
        list.add(new Cars(3,"https://i.pinimg.com/736x/3f/3b/1d/3f3b1db59ac0c4c8c2353228b5140d12.jpg","Toyata3",5000003));
        list.add(new Cars(4,"https://i.pinimg.com/736x/06/a4/19/06a419ce0f4ffea11529ca04fba34865.jpg","Toyata4",5000004));
    }



    @GetMapping("view")
    public String viewCart(Model model){
        List<Car> carList = service.returnCars(userController.currentUser);
        model.addAttribute("name", userController.currentUser.getUserName());
        model.addAttribute("cars",carList);
        return "Viewcart";
    }

    @GetMapping("/add/{carid}")
    public String addToCart(@PathVariable int carid){
        Car car = new Car();
        addCars();
        getCars(carid);
        if (cars != null){
            car.setCarId(carid);
            car.setUser(userController.currentUser);
            car.setModel(cars.getModel());
            car.setPrice(cars.getPrice());
            car.setImageAddress(cars.getCarURL());
        }
        service.save(car);
        return "Dashboard";
    }

    public void getCars(int id){
        for(Cars c : list){
            if (c.getCarId() == id){
                cars = c;
            }
        }
    }

    @GetMapping("/delete/{carid}")
    public String deleteCar(@PathVariable("carid") Long carid) {
        service.delete(carid);
        return "Dashboard";
    }

    @GetMapping("returnHome")
    public String returnHome(){
        return "Dashboard";
    }

}
