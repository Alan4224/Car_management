package com.soa.car_management.service;

import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import com.soa.car_management.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarRespondDTO> getCar();
    List<CarRespondDTO> createListCar(List<Car> cars);
    CarRespondDTO crawData(String url);
    void test();
}