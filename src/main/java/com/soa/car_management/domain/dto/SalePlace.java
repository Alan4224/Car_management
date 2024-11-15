package com.soa.car_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SalePlace {
    private String region;
    private Integer sales;
}
