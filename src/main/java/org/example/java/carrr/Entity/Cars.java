package org.example.java.carrr.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Cars {


    private int carId;
    private String carURL;
    private String model;
    private double price;

    public Cars(int carId,String carURL, String model,int price ){
        this.carId = carId;
        this.carURL = carURL;
        this.model = model;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarURL() {
        return carURL;
    }

    public void setCarURL(String carURL) {
        this.carURL = carURL;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
