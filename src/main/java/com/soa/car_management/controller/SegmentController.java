package com.soa.car_management.controller;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.AllSegmentProj;
import com.soa.car_management.projection.SegmentDetail;
import com.soa.car_management.projection.SegmentDetailProjection;
import com.soa.car_management.service.SegmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:51344"})
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

    @GetMapping("/getAll")
    ResponseEntity<List<AllSegmentProj>> getAll(){
        return ResponseEntity.ok(segmentService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car", description = "Delete an existing car entry in the system")
    public ResponseEntity<Void> deleteSegment(@Parameter(description = "ID of the car to be deleted") @PathVariable String id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.noContent().build();
    }
}
