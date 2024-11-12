package com.soa.car_management.util.mapper;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.dto.CarUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CarMapper {
    void updateCarFromDto(CarUpdateRequest carUpdateRequest, @MappingTarget Car car);
}
