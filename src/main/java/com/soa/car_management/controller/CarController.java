package com.soa.car_management.controller;

import com.soa.car_management.entity.Car;
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

    @GetMapping
    List<Car> getCar(){
        return carService.getCar();
    }
    @PostMapping
    List<Car> createCar(){
        List<Car> cars = new ArrayList<>();
        return carService.createListCar(cars);
    }

    @GetMapping("/test")
    void test(){
        Class<Car> carClass = Car.class;

        System.out.println("Fields of Car class:");
        for (Field field : carClass.getDeclaredFields()) {
            System.out.println(field.getName()+" "+field.getType());
        }
        try {
            Document doc_base = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car/so-sanh-xe/versions/650,41,66,92").get();
            List<String> labels = doc_base.select("div.title").stream().map(Element::text).collect(Collectors.toList());
            for (String label : labels) {
                System.out.println(label);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/testjsoup")
    Car testJsoup(@RequestBody Map<String, String> request) {
        String url = request.get("url");
        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            return carService.crawData(url);
        } else {
            throw new IllegalArgumentException("Malformed URL: " + url);
        }
    }
}
