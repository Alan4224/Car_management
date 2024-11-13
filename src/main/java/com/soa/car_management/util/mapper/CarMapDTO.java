package com.soa.car_management.util.mapper;

import com.soa.car_management.domain.dto.GetAllDTO;
import com.soa.car_management.domain.dto.SaleFuelDTO;

import java.util.ArrayList;
import java.util.List;

public class CarMapDTO {
    public static List<GetAllDTO> toGetAllDTO(Object[][] objects){
        List<GetAllDTO> getAllDTOS =new ArrayList<>();
        for (Object[] obj : objects) {
            GetAllDTO dto = new GetAllDTO();
            dto.setCompany((String) obj[0]);
            dto.setName((String) obj[1]);
            dto.setVersion((String) obj[2]);
            dto.setEngineType((String) obj[3]);
            dto.setPrice((String) obj[4]);
            getAllDTOS.add(dto);
        }
        return getAllDTOS;
    }
}
