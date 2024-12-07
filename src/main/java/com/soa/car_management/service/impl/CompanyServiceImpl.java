package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CarDetailDTO;
import com.soa.car_management.projection.CompanyDetailDTO;
import com.soa.car_management.projection.CompanyLabelProjection;
import com.soa.car_management.repository.CarRepository;
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

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CompanyLabelProjection> getLabel() {
        return companyRepository.findAllProjectedBy();
    }

    @Override
    public CompanyDetailDTO getDetail(String name){
        List<Object[]> comDt = companyRepository.findCompanyDetailByName(name);
        CompanyDetailDTO companyDetailDTO = new CompanyDetailDTO();
        companyDetailDTO.setName((String) comDt.getFirst()[0]);
        companyDetailDTO.setImg((String) comDt.getFirst()[1]);
        companyDetailDTO.setDescription((String) comDt.getFirst()[2]);
        List<Object[]> carDt= companyRepository.findCarDetailsByCompanyName(name);
        List<CarDetailDTO> carDetailDTOS = new ArrayList<>();
        for(Object[] obj : carDt){
            CarDetailDTO carDetailDTO = new CarDetailDTO();
            carDetailDTO.setName((String) obj[0]);
            carDetailDTO.setImg((String) obj[1]);
            carDetailDTO.setPrice((String) obj[2]);
            carDetailDTO.setLink((String) obj[3]);
            carDetailDTOS.add(carDetailDTO);
        }
        companyDetailDTO.setCarDetailDTOS(carDetailDTOS);
        return companyDetailDTO;
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
                List<Car> cars = new ArrayList<>();
                for (Car car : carRepository.findAll()){
                    if(car.getCompany().equals(company.getName())){
                        cars.add(car);
                    }
                }
                company.setCars(cars);
                coms.add(company);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return companyRepository.saveAll(coms);
    }
}
