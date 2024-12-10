package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.SegmentDetailProjection;

import java.util.List;

public interface SegmentService {
    List<SegmentDetailProjection> getDetail();
    List<Segment> craw();
}
