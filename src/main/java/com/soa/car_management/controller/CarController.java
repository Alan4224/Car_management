package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.projection.CarDTO;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:51344"})
@RestController
@RequestMapping("/car")
@Tag(name = "Car Management", description = "APIs for managing car data")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @Operation(summary = "Crawl car data", description = "Crawl car data from external sources and store it in the system")
    @GetMapping("/crawdata")
    List<Car> crawData() {
        return carService.crawData();
    }
    @Operation(summary = "So sánh các xe", description = "Lấy ra thông tin của các xe cần so sánh")
    @GetMapping("/so-sanh")
    public ResponseEntity<List<Car>> soSanh(@Parameter(description = "Thông tin hãng, tên, version") @RequestParam String names){
        return ResponseEntity.ok(carService.soSanh(names));
    }

    @PostMapping
    @Operation(summary = "Create a new car", description = "Create a new car entry in the system")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car", description = "Delete an existing car entry in the system")
    public ResponseEntity<Void> deleteCar(@Parameter(description = "ID of the car to be deleted") @PathVariable String id) {
        carService.deleteCar(id); return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get car information", description = "Retrieve car information based on company, name, and version")
    public ResponseEntity<Object> getCarInfo( @Parameter(description = "Name of the company") @RequestParam(required = false) String company,
                                              @Parameter(description = "Name of the car") @RequestParam(required = false) String name,
                                              @Parameter(description = "Version of the car") @RequestParam(required = false) String version) {
        if (company == null && name == null && version == null) {
            return ResponseEntity.ok(carService.getAllCar());
        }
        else if (company != null && name != null && version != null) {
            return ResponseEntity.ok(carService.getCarByCompanyAndNameAndVersion(company, name, version));
        }
        return ResponseEntity.badRequest().body(null);
    }
}

