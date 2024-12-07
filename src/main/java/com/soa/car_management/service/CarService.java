package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.projection.GetAllProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCarInfo();
    List<String> getAllCompany();
//    List<String> getAllCarName(String company);
//    List<String> getAllVersion(String company,String carName);
    List<Car> crawData();
//    List<Car> getCarByCompany(String carCompany);
//    List<Car> getCarByCompanyAndName(String company, String carName);
//    List<Car> getCarByCompanyAndNameAndVersion(String company, String carName,String carVersion);
    List<GetAllProjection> getAllCar();
    Car createCar(Car car);
    void deleteCar(String id);
}