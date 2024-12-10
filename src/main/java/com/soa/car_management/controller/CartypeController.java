package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.CartypeProjection;
import com.soa.car_management.service.CartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/loai-xe")
public class CartypeController {
    @Autowired
    CartypeService cartypeService;

    @GetMapping("/craw")
    ResponseEntity<List<Cartype>> crawcartype(){
        return ResponseEntity.ok(cartypeService.crawcartype());
    }

    @GetMapping
    ResponseEntity<List<CartypeProjection>> getLabel1(){
        return ResponseEntity.ok(cartypeService.getLabel1());
    }

//    @GetMapping("/{name}")
//    ResponseEntity<List<CartypeDetailProjection>> getDetail(){
//        return
//    }
}
