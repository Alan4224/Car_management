package com.soa.car_management.service.impl;

import com.soa.car_management.projection.*;
import com.soa.car_management.repository.SaleRepository;
import com.soa.car_management.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Override
    public List<SaleMonthProjection> topMonth(Integer month) {
        return saleRepository.topMonth(month);
    }

    @Override
    public List<SaleFuelProjection> saleFuel() {
        return saleRepository.saleFuel();
    }

    @Override
    public List<SalePlaceProjection> salePlace() {
        List<SalePlaceProjection> salePlaceProjections =new ArrayList<>();
        List<Object[]> objects = saleRepository.salePlace();
        for (Object[] obj : objects) {
            List<SalePlace> salePlaces=new ArrayList<>();
            String[] regions={"Northern","Central","Southern","TotalSale"};
            for(int i=0;i<4;i++){
                SalePlace salePlace=new SalePlace(regions[i],((Number) obj[i+2]).intValue());
                salePlaces.add(salePlace);
            }
            SalePlaceProjection dto = new SalePlaceProjection();
            dto.setCompanyAndName((String) obj[0]+" "+(String) obj[1]);
            dto.setData(salePlaces);
            salePlaceProjections.add(dto);
        }
        return salePlaceProjections;
    }

    @Override
    public List<PriceRangeProjection> priceRange() {
        return saleRepository.priceRange();
    }
}
