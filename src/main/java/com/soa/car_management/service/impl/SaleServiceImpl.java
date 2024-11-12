package com.soa.car_management.service.impl;

import com.soa.car_management.domain.dto.SaleFuelDTO;
import com.soa.car_management.domain.dto.SaleMonthDTO;
import com.soa.car_management.domain.dto.SalePlaceDTO;
import com.soa.car_management.repository.SaleRepository;
import com.soa.car_management.service.SaleService;
import com.soa.car_management.util.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Override
    public List<SaleMonthDTO> topMonth(Integer month) {
        return SaleMapper.toSaleMonthDTO(saleRepository.topMonth(month));
    }

    @Override
    public List<SaleFuelDTO> saleFuel() {
        return SaleMapper.toSaleFuelDTO(saleRepository.saleFuel());
    }

    @Override
    public List<SalePlaceDTO> salePlace() {
        return SaleMapper.toSalePlaceDTO(saleRepository.salePlace());
    }
}
