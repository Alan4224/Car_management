package com.soa.car_management.service;

import com.soa.car_management.domain.Car;
import com.soa.car_management.domain.request.CarUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCar();
    List<Car> crawData();
    List<Car> getCarByCompany(String carCompany);
    List<String> getAllCompany();
    Car getCarByName(String carName);
    Car createCar(Car car);
    Car updateCar(String id, CarUpdateRequest carUpdateRequest);
    String deleteCar(String id);
}