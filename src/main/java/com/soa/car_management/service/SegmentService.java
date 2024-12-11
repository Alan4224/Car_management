package com.soa.car_management.service;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.SegmentDetail;
import com.soa.car_management.projection.SegmentDetailProjection;

import java.util.List;

public interface SegmentService {
    SegmentDetail getDetail(String name);
    List<SegmentDetailProjection> getLabel();
    List<Segment> craw();
}
