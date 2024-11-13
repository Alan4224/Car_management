package com.soa.car_management.service;

import com.soa.car_management.domain.dto.GetAllDTO;
import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.dto.CarUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<String> getAllCompany();
    List<String> getAllCarName(String company);
    List<String> getAllVersion(String company,String carName);
    List<Car> crawData();
    List<Car> getCarByCompany(String carCompany);
    List<Car> getCarByCompanyAndName(String company, String carName);
    List<Car> getCarByCompanyAndNameAndVersion(String company, String carName,String carVersion);
    List<GetAllDTO> getAllCar();
    Car createCar(Car car);
    Car updateCar(String id, CarUpdateRequest carUpdateRequest);
    void deleteCar(String id);
}