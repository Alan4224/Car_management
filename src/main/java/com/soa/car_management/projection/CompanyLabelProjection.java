package com.soa.car_management.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CompanyLabelProjection {
    String getImg();
    String getName();
    @Value("#{T(java.lang.String).format('/hang-xe/%s', target.name)}")
    String getLink();
}
