package com.soa.car_management.controller;

import com.soa.car_management.domain.Car;
import com.soa.car_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody Car car){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }

    @DeleteMapping
    ResponseEntity<String> deleteCar(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(carService.deleteCar(id));
    }

    @GetMapping("/companies")
    ResponseEntity<List<String>> getAllCompanies(){
        return ResponseEntity.ok(carService.getAllCompany());
    }

    @GetMapping("/hang-xe/{carCompany}")
    ResponseEntity<List<Car>> getCarByCompany(@PathVariable String carCompany){
        return ResponseEntity.ok(carService.getCarByCompany(carCompany));
    }

    @GetMapping("/dong-xe/{carName}")
    ResponseEntity<Car> getCarByName(@PathVariable String carName){
        return ResponseEntity.ok(carService.getCarByName(carName));
    }
}
