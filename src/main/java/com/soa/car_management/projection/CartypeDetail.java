package com.soa.car_management.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class CartypeDetail {
    private String name;
    private String img;
    private String description;
    private List<CarDetail> carDetails;
}
