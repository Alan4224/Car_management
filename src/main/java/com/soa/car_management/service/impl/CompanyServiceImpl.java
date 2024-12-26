package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CarDetail;
import com.soa.car_management.projection.CompanyDetail;
import com.soa.car_management.projection.CompanyDetailProjection;
import com.soa.car_management.projection.CompanyLabelProjection;
import com.soa.car_management.repository.CompanyRepository;
import com.soa.car_management.service.CompanyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<CompanyLabelProjection> getLabel() {
        return companyRepository.findAllProjectedBy();
    }

    @Override
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    @Override
    public CompanyDetail getDetail(String name){
         List<CompanyDetailProjection> data = companyRepository.findProjectedByName(name);
         List<CarDetail> carDetails = new ArrayList<>();
         for (int i=0;i< data.size();i++){
             String carName = data.get(i).getCarname();
             String carImage= data.get(i).getCarimage();
             String carPrice= data.get(i).getCarprice();
             String carLink= data.get(i).getLink();
             CarDetail carDetail = new CarDetail(carName,carImage,carPrice,carLink);
             carDetails.add(carDetail);
         }
         String companyName = data.getFirst().getName();
         String companyImg = data.getFirst().getImg();
         String companyDescription = data.getFirst().getDescription();
        return new CompanyDetail(companyName,companyImg,companyDescription,carDetails);
    }

    @Override
    public List<Company> craw() {
        List<Company> coms = new ArrayList<>();
        try {
            Document trangTong = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car").get();
            Elements hangXe = trangTong.select("div.grid.grid__8.list-hangxe.list-company-home a");
            List<String> linkHangXes = hangXe.stream().map(element -> element.attr("href")).toList();

            for (String linkHangXe : linkHangXes) {
                Document trangHang = Jsoup.connect("https://vnexpress.net" + linkHangXe).get();
                Company company = new Company();
                Element div = trangHang.select("div.container.info-hang-xe.flex").first();
                String img = div.select("div.img img").attr("src");
                String name = div.select("h1.name").text();
                String description = div.select("div.content p").get(1).text();
                company.setImg(img);
                company.setName(name);
                company.setDescription(description);
                coms.add(company);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return companyRepository.saveAll(coms);
    }
}
