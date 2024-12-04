package com.soa.car_management.controller;

import com.soa.car_management.projection.PriceRangeProjection;
import com.soa.car_management.projection.SaleFuelProjection;
import com.soa.car_management.projection.SaleMonthProjection;
import com.soa.car_management.projection.SalePlaceProjection;
import com.soa.car_management.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
@Tag(name = "Sale Statistics", description = "APIs for statistic sale data")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/topmonth")
    @Operation(summary = "Top 10 best seller companies", description = "Top 10 best seller company in a month for column chart")
    ResponseEntity<List<SaleMonthProjection>> topMonth(@Parameter(description = "month")@RequestParam Integer month){
        return ResponseEntity.ok(saleService.topMonth(month));
    }

    @GetMapping("/salefuel")
    @Operation(summary = "Number of sale each fuel", description = "Number of sale each fuel for round chart")
    ResponseEntity<List<SaleFuelProjection>> saleFuel(){
        return ResponseEntity.ok(saleService.saleFuel());
    }

    @GetMapping("/saleplace")
    @Operation(summary = "Top 5 best seller cars", description = "Top 5 best seller cars for horizontal column chart")
    ResponseEntity<List<SalePlaceProjection>>salePlace(){
        return ResponseEntity.ok(saleService.salePlace());
    }

    @GetMapping("/pricerange")
    @Operation(summary = "Price range from 500 triệu to 20 tỷ", description = "Price range for round chart")
    ResponseEntity<List<PriceRangeProjection>> priceRange(){
        return ResponseEntity.ok(saleService.priceRange());
    }
}
