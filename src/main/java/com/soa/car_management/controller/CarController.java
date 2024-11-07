package com.soa.car_management.controller;

import com.soa.car_management.domain.Car;
import com.soa.car_management.domain.request.CarUpdateRequest;
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
    List<Car> crawData() {
        return carService.crawData();
    }

    @GetMapping("/companies")
    ResponseEntity<List<String>> getAllCompanies() {
        return ResponseEntity.ok(carService.getAllCompany());
    }

    @GetMapping("/dong-xe/{company}")
    ResponseEntity<List<String>> getAllCarNames(@PathVariable String company){
        return ResponseEntity.ok(carService.getAllCarName(company));
    }

    @GetMapping("/phien-ban/{company}/{carName}")
    ResponseEntity<List<String>> getAllCarVersions(@PathVariable String company,@PathVariable String carName){
        return ResponseEntity.ok(carService.getAllVersion(company,carName));
    }

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }

    @PutMapping("/{id}")
    ResponseEntity<Car> updateCar(@PathVariable String id, @RequestBody CarUpdateRequest carUpdateRequest) {
        return ResponseEntity.ok(carService.updateCar(id, carUpdateRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<List<Car>> getCarInfo(@RequestParam(required = false) String company,
                                         @RequestParam(required = false) String name,
                                         @RequestParam(required = false) String version) {
        if (company == null && name == null && version == null) {
            return ResponseEntity.ok(carService.getAllCar());
        } else if (company != null && name == null && version == null) {
            return ResponseEntity.ok(carService.getCarByCompany(company));
        } else if (company != null && name != null && version == null) {
            return ResponseEntity.ok(carService.getCarByCompanyAndName(company, name));
        } else if (company != null && name != null && version != null) {
            return ResponseEntity.ok(carService.getCarByCompanyAndNameAndVersion(company, name, version));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
