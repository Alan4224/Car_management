package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.CarDetail;
import com.soa.car_management.projection.CartypeDetail;
import com.soa.car_management.projection.CartypeProjection;
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

    @Override
    public CartypeDetail getDetail(String name) {
        List<Object[]> data = cartypeRepository.findProjectedByName(name);
        List<CarDetail> carDetails = new ArrayList<>();
        for(Object[] obj : data){
            String carName = (String) obj[3];
            String carImage = (String) obj[4];
            String carPrice = (String) obj[5];
            String carVersion = (String) obj[6];
            String company = (String) obj[7];
            String carLink = String.format("/car?company=%s&name=%s&version=%s",company,carName,carVersion);
            CarDetail carDetail = new CarDetail(carName,carImage,carPrice,carLink);
            carDetails.add(carDetail);
        }
        String ctpName = (String) data.getFirst()[0];
        String ctpImg = (String) data.getFirst()[1];
        String description = (String) data.getFirst()[2];
        return new CartypeDetail(ctpName,ctpImg,description,carDetails);
    }

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
                types.add(cartype);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return cartypeRepository.saveAll(types);
    }
}
