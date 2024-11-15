package com.soa.car_management.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SalePlaceDTO {
    private String companyAndName;
    private List<SalePlace> data;
}



