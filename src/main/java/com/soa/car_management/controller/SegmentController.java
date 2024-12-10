package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.CompanyDetailProjection;
import com.soa.car_management.projection.CompanyLabelProjection;
import com.soa.car_management.projection.SegmentDetailProjection;
import com.soa.car_management.service.CompanyService;
import com.soa.car_management.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phan-khuc")
public class SegmentController {
    @Autowired
    SegmentService segmentService;

    @GetMapping("/craw")
    ResponseEntity<List<Segment>> craw(){
        return ResponseEntity.ok(segmentService.craw());
    }

    @GetMapping
    ResponseEntity<List<SegmentDetailProjection>> getLabel(){
        return ResponseEntity.ok(segmentService.getDetail());
    }

//    @GetMapping("/{name}")
//    ResponseEntity<List<CompanyDetailProjection>> getDetail(){
//        return
//    }
}
