package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Sale;
import com.soa.car_management.projection.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    List<AllMonthProjection> allMonth();
    List<SaleMonthProjection> topMonth(Integer month);
    List<SaleFuelProjection> saleFuel();
    List<SalePlaceProjection> salePlace();
    List<PriceRangeProjection> priceRange();
    List<Sale> crawl();
}
