package com.soa.car_management.service.impl;

import com.soa.car_management.entity.Car;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> createListCar(List<Car> cars) {
        return carRepository.saveAll(cars);
    }
}
