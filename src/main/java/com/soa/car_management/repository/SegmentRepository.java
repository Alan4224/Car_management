package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.SegmentDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface SegmentRepository extends JpaRepository<Segment,String> {
    List<SegmentDetailProjection> findAllProjectedBy();
}
