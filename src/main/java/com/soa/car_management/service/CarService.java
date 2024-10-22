package com.soa.car_management.service;

import com.soa.car_management.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getCar();
    List<Car> createListCar(List<Car> cars);
}
