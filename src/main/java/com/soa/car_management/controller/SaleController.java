package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.domain.entity.Sale;
import com.soa.car_management.projection.*;
import com.soa.car_management.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:51344"})
@RequestMapping("/sale")
@Tag(name = "Sale Statistics", description = "APIs for statistic sale data")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/crawl")
    ResponseEntity<List<Sale>> crawl(){
        return ResponseEntity.ok(saleService.crawl());
    }

    @GetMapping("/allmonth")
    ResponseEntity<List<AllMonthProjection>> allMonth(){
        return ResponseEntity.ok(saleService.allMonth());
    }

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
