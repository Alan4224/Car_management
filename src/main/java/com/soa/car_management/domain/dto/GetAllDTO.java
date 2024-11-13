package com.soa.car_management.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllDTO {
    private String company;
    private String name;
    private String version;
    private String engineType;
    private String price;
}
