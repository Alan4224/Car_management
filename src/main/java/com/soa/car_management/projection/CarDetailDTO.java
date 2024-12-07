package com.soa.car_management.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailDTO {
    private String name;
    private String img;
    private String price;
    private String link;
}
