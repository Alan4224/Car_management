package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.AllCarTypeProj;
import com.soa.car_management.projection.CartypeDetail;
import com.soa.car_management.projection.CartypeProjection;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartypeService {
    CartypeDetail getDetail(String name);
    List<CartypeProjection> getLabel1();
    List<Cartype> crawcartype();
    List<AllCarTypeProj> getAll();
}
