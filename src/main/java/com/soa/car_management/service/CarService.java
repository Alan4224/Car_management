package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.projection.CarDTO;
import com.soa.car_management.projection.GetAllProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCarInfo();
    List<Car> crawData();
    List<Car> soSanh(String names);
    Car getCarByCompanyAndNameAndVersion(String company, String carName,String carVersion);
    List<GetAllProjection> getAllCar();
    Car createCar(Car car);
    void deleteCar(String id);
}