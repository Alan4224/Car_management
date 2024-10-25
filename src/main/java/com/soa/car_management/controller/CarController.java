package com.soa.car_management.controller;

import com.soa.car_management.dto.request.CarRequestDTO;
import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import com.soa.car_management.mapper.CarMapper;
import com.soa.car_management.service.CarService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


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

    @GetMapping("/testlist")
    List<CarRespondDTO> testlist(){
        List<CarRespondDTO> cars = new ArrayList<>();
        try {
            Document trangTong = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car").get();
            Elements hangXe = trangTong.select("div.grid.grid__8.list-hangxe.list-company-home a");
            List<String> linkHangXes = hangXe.stream().map(element -> element.attr("href")).toList();

            for (String linkHangXe : linkHangXes) {
                Document trangHang = Jsoup.connect("https://vnexpress.net"+linkHangXe).get();
                Elements divsTrangTongXe = trangHang.select("div.list-xe.list-xe__company.grid.grid__4.mb60 div.article-thumb a");
                List<String> linkTrangTongXes = divsTrangTongXe.stream().map(element -> element.attr("href")).toList();
                for(String linkTrangTongXe : linkTrangTongXes){
                    if (!linkTrangTongXe.startsWith("https://vnexpress.net")) {
                        linkTrangTongXe =  "https://vnexpress.net"+ linkTrangTongXe; // Prepend the base URL if it's a relative link
                    }
                    System.out.println(linkTrangTongXe);
                    Document trangTongXe = Jsoup.connect(linkTrangTongXe).get();
                    String linkTrangKiThuat = trangTongXe.select("div.load-more.center.mt20 a").attr("href");
                    linkTrangKiThuat = "https://vnexpress.net"+linkTrangKiThuat;
                    System.out.println(linkTrangKiThuat);
                    CarRespondDTO car=carService.crawData(linkTrangKiThuat);
                    cars.add(car);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }
}
