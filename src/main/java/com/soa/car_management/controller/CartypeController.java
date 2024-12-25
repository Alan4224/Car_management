package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.CartypeDetail;
import com.soa.car_management.projection.CartypeProjection;
import com.soa.car_management.service.CartypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:51344"})
@RequestMapping("/loai-xe")
@Tag(name = "LOẠI XE", description = "APIs for managing car type data")
public class CartypeController {
    @Autowired
    CartypeService cartypeService;

    @Operation(summary = "Crawl car type data", description = "Crawl car data from external sources and store it in the system")
    @GetMapping("/craw")
    ResponseEntity<List<Cartype>> crawcartype(){
        return ResponseEntity.ok(cartypeService.crawcartype());
    }

    @Operation(summary = "Get all car type label", description = "Get label to show on the home page")
    @GetMapping
    ResponseEntity<List<CartypeProjection>> getLabel1(){
        return ResponseEntity.ok(cartypeService.getLabel1());
    }

    @Operation(summary = "Get detail about a car type", description = "Retrieve car type information based on name")
    @GetMapping("/{name}")
    ResponseEntity<CartypeDetail> getDetail(@Parameter(description = "Name of the car type")@PathVariable String name){
        return ResponseEntity.ok(cartypeService.getDetail(name));
    }
}
