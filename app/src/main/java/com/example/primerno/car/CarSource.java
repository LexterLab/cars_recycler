package com.example.primerno.car;

import java.util.ArrayList;
import java.util.List;

public class CarSource {
    public static List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cars.add(new Car("brand" + i, "number", false));
        }
        return cars;
    }
}
