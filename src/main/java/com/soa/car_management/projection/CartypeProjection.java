package com.soa.car_management.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CartypeProjection {
    String getImg();
    String getName();
    @Value("#{T(java.lang.String).format('/loai-xe/%s', target.name)}")
    String getLink();
}
