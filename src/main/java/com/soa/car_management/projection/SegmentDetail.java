package com.soa.car_management.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class SegmentDetail {
    private String name;
    private String description;
    private List<CarDetail> carDetails;
}
