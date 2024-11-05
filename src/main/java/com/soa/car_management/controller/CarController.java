package com.soa.car_management.controller;

import com.soa.car_management.domain.Car;
import com.soa.car_management.domain.RestResponse;
import com.soa.car_management.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;


    @GetMapping("/crawdata")
    List<Car> crawData(){
        return carService.crawData();
    }


    @GetMapping
    ResponseEntity<List<Car>> getAllCar(){
        return ResponseEntity.ok(carService.getAllCar());
    }


    @GetMapping("/companies")
    ResponseEntity<List<String>> getAllCompanies(){
        return ResponseEntity.ok(carService.getAllCompany());
    }

    @Operation(summary = "Get cars by company")
    @GetMapping("/hang-xe/{carCompany}")
    ResponseEntity<List<Car>> getCarByCompany(@PathVariable String carCompany){
        return ResponseEntity.ok(carService.getCarByCompany(carCompany));
    }

    @Operation(summary = "Get car by name")
    @GetMapping("/dong-xe/{carName}")
    ResponseEntity<Car> getCarByName(@PathVariable String carName){
        return ResponseEntity.ok(carService.getCarByName(carName));
    }
}
