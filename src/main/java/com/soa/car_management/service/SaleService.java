package com.soa.car_management.service;

import com.soa.car_management.domain.dto.SaleFuelDTO;
import com.soa.car_management.domain.dto.SaleMonthDTO;
import com.soa.car_management.domain.dto.SalePlaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    List<SaleMonthDTO>topMonth(Integer month);
    List<SaleFuelDTO> saleFuel();
    List<SalePlaceDTO> salePlace();
}
