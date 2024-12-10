package com.soa.car_management.service.impl;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Sale;
import com.soa.car_management.projection.*;
import com.soa.car_management.repository.CarRepository;
import com.soa.car_management.repository.SaleRepository;
import com.soa.car_management.service.CarService;
import com.soa.car_management.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

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

    @Override
    public List<Sale> crawl(){
        Random random = new Random();
        int originMinN = 0;
        int originMaxN = 546;
        int originMinC = 0;
        int originMaxC = 334;
        int originMinS = 0;
        int originMaxS = 764;
        List<Car> cars = carService.getAllCarInfo();
        List<Sale> sales = new ArrayList<>();
        for(int i =0;i<cars.size();i++){
            int chia=carRepository.getAllByCompanyAndName(cars.get(i).getCompany().getName(),cars.get(i).getName()).size();
            int minN = originMinN / chia;
            int maxN = originMaxN / chia;
            int minC = originMinC / chia;
            int maxC = originMaxC / chia;
            int minS = originMinS / chia;
            int maxS = originMaxS / chia;
            for(int j=1;j<13;j++){
                Sale sale = new Sale();
                sale.setMonth(j);
                sale.setNorth(random.nextInt(maxN - minN + 1) + minN);
                sale.setSouth(random.nextInt(maxS - minS + 1) + minS);
                sale.setCentral(random.nextInt(maxC - minC + 1) + minC);
                sale.setCar(cars.get(i));
                sales.add(sale);
            }
        }
        return saleRepository.saveAll(sales);
    }
}
