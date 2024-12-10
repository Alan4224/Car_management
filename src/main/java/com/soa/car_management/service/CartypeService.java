package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CartypeProjection;
import com.soa.car_management.projection.CompanyLabelProjection;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartypeService {
    List<CartypeProjection> getLabel1();
    List<Cartype> crawcartype();
}
