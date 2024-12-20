package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.SegmentDetail;
import com.soa.car_management.projection.SegmentDetailProjection;
import com.soa.car_management.service.SegmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phan-khuc")
@Tag(name = "PHÂN KHÚC", description = "APIs for managing car company data")
public class SegmentController {
    @Autowired
    SegmentService segmentService;

    @Operation(summary = "Crawl segment data", description = "Crawl segment data from external sources and store it in the system")
    @GetMapping("/craw")
    ResponseEntity<List<Segment>> craw(){
        return ResponseEntity.ok(segmentService.craw());
    }

    @Operation(summary = "Get all segment label", description = "Get label to show on the home page")
    @GetMapping
    ResponseEntity<List<SegmentDetailProjection>> getLabel(){
        return ResponseEntity.ok(segmentService.getLabel());
    }

    @Operation(summary = "Get detail about a segment", description = "Retrieve segment information based on name")
    @GetMapping("/{name}")
    ResponseEntity<SegmentDetail> getDetail(@Parameter(description = "Name of the segment")@PathVariable String name){
        return ResponseEntity.ok(segmentService.getDetail(name));
    }
}
