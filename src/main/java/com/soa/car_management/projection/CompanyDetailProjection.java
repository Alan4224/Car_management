package com.soa.car_management.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CompanyDetailProjection {
    String getName();
    String getImg();
    String getDescription();
    String getCarname();
    String getCarimage();
    String getCarprice();
    String getVersion();
    @Value("#{T(java.lang.String).format('/car?company=%s&name=%s&version=%s',target.name, target.carname, target.version)}")
    String getLink();
}
