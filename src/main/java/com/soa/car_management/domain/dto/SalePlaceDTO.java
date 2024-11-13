package com.soa.car_management.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalePlaceDTO {
    private String company;
    private String name;
    private Integer north;
    private Integer central;
    private Integer south;
    private Integer totalSale;
}



