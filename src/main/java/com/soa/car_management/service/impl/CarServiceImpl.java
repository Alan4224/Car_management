package com.soa.car_management.service.impl;

import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import com.soa.car_management.mapper.CarMapper;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.service.CarService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CarMapper carMapper;

    @Override
    public List<CarRespondDTO> getAllCar() {
        System.out.println(carRepository.count());
        return carRepository.findAll().stream().map(carMapper::toCarRespondDTO).toList();
    }

    @Override
    public void test() {
        Class<Car> carClass = Car.class;

        System.out.println("Fields of Car class:");
        for (Field field : carClass.getDeclaredFields()) {
            System.out.println(field.getName()+" "+field.getType());
        }
        try {
            Document doc_base = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car/so-sanh-xe/versions/650,41,66,92").get();
            List<String> labels = doc_base.select("div.title").stream().map(Element::text).toList();
            for (String label : labels) {
                System.out.println(label);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CRAW DATA
    @Override
    public List<CarRespondDTO> crawData() {
        List<Car> cars = new ArrayList<>();
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
                    Document trangTongXe = Jsoup.connect(linkTrangTongXe).get();
                    String linkTrangKiThuat = trangTongXe.select("div.load-more.center.mt20 a").attr("href");
                    linkTrangKiThuat = "https://vnexpress.net"+linkTrangKiThuat;
                    Car car=craw(linkTrangKiThuat);
                    String linkImg=trangTongXe.select("a.thumb_img.thumb_5x3.detail-icon-gallery picture img").attr("src");
                    car.setImage(linkImg);
                    cars.add(car);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return carRepository.saveAll(cars).stream().map(car -> carMapper.toCarRespondDTO(car)).toList();
    }

    private Car craw (String url){
        Car car = new Car();
        try {
            Class<Car> carClass = Car.class;
            Field[] attributes = carClass.getDeclaredFields();
            Document doc_base = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car/so-sanh-xe/versions/650,41,66,92").get();
            List<String> labels = doc_base.select("div.title").stream().map(Element::text).toList();
            // Fetch the HTML from a URL
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("li");
            for (Element element : elements) {
                String label = element.select("div.td1").text();
                String value = element.select("div.td2").text();
                String name = doc.select("h1").select("a[title]").first().attr("title");
                car.setName(name);
                String price = doc.select("span.text-version").first().text();
                car.setPrice(price);
                for (int i = 0; i < labels.size(); i++) {
                    if (labels.get(i).equals(label)) {
                        String attribute = attributes[i + 4].getName();
                        if (attributes[i + 4].getType().equals(String.class)) {
                            setAttributeString(attribute, value, car);
                        } else if (attributes[i + 4].getType().equals(Boolean.class)) {
                            setAttributeBoolean(attribute, element, car);
                        } else if (attributes[i + 4].getType().equals(Double.class)) {
                            setAttributeDouble(attribute, value, car);
                        } else if (attributes[i + 4].getType().equals(Integer.class)) {
                            setAttributeInteger(attribute, value, car);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    private Boolean hasCheckIcon(Element element) {
        return element.select("div.td2 svg.icon-svg").size() > 0;
    }

    private void setAttributeString(String attribute, String value, Car car) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        car.getClass().getMethod(methodName, String.class).invoke(car, value.isEmpty() ? null : value);
    }

    private void setAttributeBoolean(String attribute, Element element, Car car) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        Boolean value = hasCheckIcon(element);
        car.getClass().getMethod(methodName, Boolean.class).invoke(car, value);
    }

    private void setAttributeDouble(String attribute, String value, Car car) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        car.getClass().getMethod(methodName, Double.class).invoke(car, value.isEmpty() ? null : Double.parseDouble(value.replace(",", ".")));
    }

    private void setAttributeInteger(String attribute, String value, Car car) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        car.getClass().getMethod(methodName, Integer.class).invoke(car, value.isEmpty() ? null : Integer.parseInt(value));
    }

    //END CRAW DATA
}
