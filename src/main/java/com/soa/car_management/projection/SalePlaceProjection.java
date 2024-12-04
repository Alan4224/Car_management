package com.soa.car_management.projection;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class SalePlaceProjection {
    private String companyAndName;
    private List<SalePlace> data;
}
