package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Segment;
import com.soa.car_management.projection.AllSegmentProj;
import com.soa.car_management.projection.SegmentDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface SegmentRepository extends JpaRepository<Segment,String> {
    List<SegmentDetailProjection> findAllProjectedBy();
    Segment findByName(String name);

    @Query(value = "SELECT seg.name, seg.description, c.name as carname, \n" +
            "c.image as carimage, concat(min(c.price),'-',max(c.price)) AS carprice, \n" +
            "ANY_VALUE(c.version) as version , ANY_VALUE(com.name) as company\n" +
            "FROM car c\n" +
            "JOIN company com on c.company_id = com.id\n" +
            "JOIN segment seg ON c.segment_id = seg.id \n" +
            "WHERE seg.name = :name \n" +
            "GROUP BY c.name, seg.name, seg.description, c.image"
    ,nativeQuery = true)
    List<Object[]> findProjectedByName(@Param("name") String name);

    @Query(value = "SELECT s.id, s.name, s.description, COUNT( distinct c.name) as count\n" +
            "FROM segment s\n" +
            "JOIN car c ON c.segment_id = s.id\n" +
            "GROUP BY s.id, s.name, s.description;",nativeQuery = true)
    List<AllSegmentProj> getAll();
}
