package com.soa.car_management.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDetailDTO {
    private String name;
    private String img;
    private String description;
    private List<CarDetailDTO> carDetailDTOS;
}
