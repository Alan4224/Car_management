package com.soa.car_management.mapper;

import com.soa.car_management.dto.request.CarRequestDTO;
import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CarMapper {
    CarRespondDTO toCarRespondDTO(Car car);
    Car toCar(CarRequestDTO carRequestDTO);
}
