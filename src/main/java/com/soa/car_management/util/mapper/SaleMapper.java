package com.soa.car_management.util.mapper;

import com.soa.car_management.domain.dto.PriceRangeDTO;
import com.soa.car_management.domain.dto.SaleFuelDTO;
import com.soa.car_management.domain.dto.SaleMonthDTO;
import com.soa.car_management.domain.dto.SalePlaceDTO;

import java.util.ArrayList;
import java.util.List;

public class SaleMapper {
    public static List<SaleMonthDTO> toSaleMonthDTO(Object[][] objects){
        List<SaleMonthDTO> saleMonthDTOS =new ArrayList<>();
        for (Object[] obj : objects) {
            SaleMonthDTO dto = new SaleMonthDTO();
            dto.setCompany((String) obj[0]);
            dto.setTotalSale(((Number) obj[1]).intValue());
            saleMonthDTOS.add(dto);
        }
        return saleMonthDTOS;
    }

    public static List<SaleFuelDTO> toSaleFuelDTO(Object[][] objects){
        List<SaleFuelDTO> saleFuelDTOS =new ArrayList<>();
        for (Object[] obj : objects) {
            SaleFuelDTO dto = new SaleFuelDTO();
            dto.setFuelType((String) obj[0]);
            dto.setTotalSale(((Number) obj[1]).intValue());
            saleFuelDTOS.add(dto);
        }
        return saleFuelDTOS;
    }

    public static List<SalePlaceDTO> toSalePlaceDTO(Object[][] objects){
        List<SalePlaceDTO> salePlaceDTOS =new ArrayList<>();
        for (Object[] obj : objects) {
            SalePlaceDTO dto = new SalePlaceDTO();
            dto.setCompany((String) obj[0]);
            dto.setName((String) obj[1]);
            dto.setNorth(((Number) obj[2]).intValue());
            dto.setCentral(((Number) obj[3]).intValue());
            dto.setSouth(((Number) obj[4]).intValue());
            dto.setTotalSale(((Number) obj[5]).intValue());
            salePlaceDTOS.add(dto);
        }
        return salePlaceDTOS;
    }

    public static List<PriceRangeDTO> toPriceRangeDTO(Object[][] objects){
        List<PriceRangeDTO> priceRangeDTOS =new ArrayList<>();
        for (Object[] obj : objects) {
            PriceRangeDTO dto = new PriceRangeDTO();
            dto.setPriceRange((String) obj[1]);
            dto.setTotalSale(((Number) obj[0]).intValue());
            priceRangeDTOS.add(dto);
        }
        return priceRangeDTOS;
    }
}
