package com.soa.car_management.domain.dto;

//import lombok.Getter;
//import lombok.Setter;
//
//@Setter
//@Getter
//public class SaleFuelDTO {
//    private String fuelType;
//    private Integer totalSale;
//}

public class SaleFuelDTO {
    private String fuelType;
    private int totalSale;

    // Các getter và setter cho các thuộc tính này

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }
}
