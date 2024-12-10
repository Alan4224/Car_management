package com.soa.car_management.projection;

import org.springframework.beans.factory.annotation.Value;

public interface SegmentDetailProjection {

    String getName();
    String getDecription();
    @Value("#{T(java.lang.String).format('/phan-khuc/%s', target.name)}")
    String getLink();
}
