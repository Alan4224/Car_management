package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CompanyDetailDTO;
import com.soa.car_management.projection.CompanyLabelProjection;
import com.soa.car_management.repository.CompanyRepository;
import com.soa.car_management.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hang-xe")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/craw")
    ResponseEntity<List<Company>> craw(){
        return ResponseEntity.ok(companyService.craw());
    }

    @GetMapping
    ResponseEntity<List<CompanyLabelProjection>> getLabel(){
        return ResponseEntity.ok(companyService.getLabel());
    }

    @GetMapping("/{name}")
    ResponseEntity<CompanyDetailDTO> getDetail(@PathVariable String name){
        return ResponseEntity.ok(companyService.getDetail(name));
    }

    @Autowired
    CompanyRepository companyRepository;
    @PutMapping("/{name}")
    Company getCompanyByName(@PathVariable String name){
        return companyRepository.findByName(name);
    }
}
