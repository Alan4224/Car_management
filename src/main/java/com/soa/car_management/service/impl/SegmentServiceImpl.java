package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.SegmentDetailProjection;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.repository.SegmentRepository;
import com.soa.car_management.service.SegmentService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {
    @Autowired
    SegmentRepository segmentRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<SegmentDetailProjection> getDetail() {
        return segmentRepository.findAllProjectedBy();
    }
    @Override
    public List<Segment> craw(){
        List<Segment> coms = new ArrayList<>();
        try {
            Document trangTong = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car").get();
            Elements phanKhuc = trangTong.select("div.phan-khuc-xe ul:nth-child(4) li a");
            List<String> linkPhanKhucs = phanKhuc.stream().map(element -> element.attr("href")).toList();

            for (String linkPhanKhuc : linkPhanKhucs) {
                Document trangCon = Jsoup.connect("https://vnexpress.net" + linkPhanKhuc).get();
                Segment segment = new Segment();
                Element div = trangCon.select("div.container.info-hang-xe.flex").first();
//                String img = div.select("div.img img").attr("src");
                String name = div.select("h1.name").text();
                String description = div.select("div.content p").get(1).text();

                segment.setName(name);
                segment.setDescription(description);
                List<Car> cars = new ArrayList<>();
                for (Car car : carRepository.findAll()){
                    {
                        cars.add(car);
                    }
                }
                segment.setCars(cars);
                coms.add(segment);
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
        return segmentRepository.saveAll(coms);
        }
}
