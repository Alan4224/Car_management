package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.CarDetail;
import com.soa.car_management.projection.SegmentDetail;
import com.soa.car_management.projection.SegmentDetailProjection;
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

    @Override
    public SegmentDetail getDetail(String name) {
        List<Object[]> data = segmentRepository.findProjectedByName(name);
        List<CarDetail> carDetails = new ArrayList<>();
        for(Object[] obj : data){
            String carName = (String) obj[2];
            String carImage = (String) obj[3];
            String carPrice = (String) obj[4];
            String carVersion = (String) obj[5];
            String company = (String) obj[6];
            String carLink = String.format("/car?company=%s&name=%s&version=%s",company,carName,carVersion);
            CarDetail carDetail = new CarDetail(carName,carImage,carPrice,carLink);
            carDetails.add(carDetail);
        }
        String segName = (String) data.getFirst()[0];
        String description = (String) data.getFirst()[1];
        return new SegmentDetail(segName,description,carDetails);
    }

    @Override
    public List<SegmentDetailProjection> getLabel() {
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
                String name = div.select("h1.name").text();
                String description = div.select("div.content p").get(1).text();
                segment.setName(name);
                segment.setDescription(description);
                coms.add(segment);
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
        return segmentRepository.saveAll(coms);
        }
}
