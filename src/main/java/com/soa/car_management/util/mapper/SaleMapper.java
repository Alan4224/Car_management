package com.soa.car_management.util.mapper;

import com.soa.car_management.domain.dto.*;

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
            List<SalePlace> salePlaces=new ArrayList<>();
            String[] regions={"Northern","Central","Southern","TotalSale"};
            for(int i=0;i<4;i++){
                SalePlace salePlace=new SalePlace(regions[i],((Number) obj[i+2]).intValue());
                salePlaces.add(salePlace);
            }
            SalePlaceDTO dto = new SalePlaceDTO();
            dto.setCompanyAndName((String) obj[0]+" "+(String) obj[1]);
            dto.setData(salePlaces);
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
