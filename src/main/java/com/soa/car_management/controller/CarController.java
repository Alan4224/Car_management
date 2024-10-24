package com.soa.car_management.controller;

import com.soa.car_management.dto.request.CarRequestDTO;
import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import com.soa.car_management.mapper.CarMapper;
import com.soa.car_management.service.CarService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarMapper carMapper;

    @GetMapping
    List<CarRespondDTO> getCar(){
        return carService.getCar();
    }
    @PostMapping
    List<CarRespondDTO> createCar(@RequestBody List<CarRequestDTO> request){
        List<Car> cars = request.stream().map(carMapper::toCar).toList();
        return carService.createListCar(cars);
    }
    @GetMapping("/test")
    void test(){
        carService.test();
    }

    @PostMapping("/testjsoup")
    CarRespondDTO testJsoup(@RequestBody Map<String, String> request) {
        String url = request.get("url");
        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            return carService.crawData(url);
        } else {
            throw new IllegalArgumentException("Malformed URL: " + url);
        }
    }
}
