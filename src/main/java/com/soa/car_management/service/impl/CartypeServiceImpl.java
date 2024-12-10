package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.CartypeProjection;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.repository.CartypeRepository;
import com.soa.car_management.service.CartypeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartypeServiceImpl implements CartypeService {
    @Autowired
    CartypeRepository cartypeRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CartypeProjection> getLabel1() {
        return cartypeRepository.findAllProjectedBy();
    }
    @Override
    public List<Cartype> crawcartype() {
        List<Cartype> types = new ArrayList<>();
        try {
            Document trangTong = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car").get();
            Elements loaiXe = trangTong.select("div.loai-xe div.grid.grid__3 div.itemt div.car a");
            List<String> linkLoaiXes = loaiXe.stream().map(element -> element.attr("href")).toList();

            for (String linkLoaiXe : linkLoaiXes) {
                Document trangLoai = Jsoup.connect("https://vnexpress.net" + linkLoaiXe).get();
                Cartype cartype = new Cartype();
                Element div = trangLoai.select("div.container.info-hang-xe.flex").first();
                String img = div.select("div.img img").attr("src");
                String name = div.select("h1.name").text();
                String description1 = div.select("div.content p").get(1).text();
                String description2 = div.select("div.content p").get(2).text();
                cartype.setImg(img);
                cartype.setName(name);
                cartype.setDescription(description1+description2);
//                List<Car> cars = new ArrayList<>();
//                for (Car car : carRepository.findAll()){
//                    if(car.getCartype().equals(cartype.getName())){
//                        cars.add(car);
//                    }
//                }
//                cartype.setCars(cars);
//                types.add(cartype);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return cartypeRepository.saveAll(types);
    }
}
