package com.soa.car_management.controller;

import com.soa.car_management.dto.respond.CarRespondDTO;

import com.soa.car_management.mapper.CarMapper;
import com.soa.car_management.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarMapper carMapper;

    @GetMapping
    List<CarRespondDTO> getAllCar(){
        return carService.getAllCar();
    }

    @GetMapping("/crawdata")
    List<CarRespondDTO> crawData(){
        return carService.crawData();
    }
}
