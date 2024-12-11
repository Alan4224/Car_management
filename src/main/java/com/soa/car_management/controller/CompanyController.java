package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CompanyDetail;
import com.soa.car_management.projection.CompanyLabelProjection;
import com.soa.car_management.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hang-xe")
@Tag(name = "HÃNG XE", description = "APIs for managing car company data")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Operation(summary = "Crawl company data", description = "Crawl car data from external sources and store it in the system")
    @GetMapping("/craw")
    ResponseEntity<List<Company>> craw(){
        return ResponseEntity.ok(companyService.craw());
    }

    @Operation(summary = "Get all company label", description = "Get label to show on the home page")
    @GetMapping
    ResponseEntity<List<CompanyLabelProjection>> getLabel(){
        return ResponseEntity.ok(companyService.getLabel());
    }

    @Operation(summary = "Get detail about a company", description = "Retrieve company information based on name")
    @GetMapping("/{name}")
    ResponseEntity<CompanyDetail> getDetail(@Parameter(description = "Name of the company")@PathVariable String name){
        return ResponseEntity.ok(companyService.getDetail(name));
    }
}
