package com.soa.car_management.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CarDetail {
    private String name;
    private String image;
    private String price;
    private String link;
}
