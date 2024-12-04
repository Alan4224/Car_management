package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CompanyLabelProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {
    List<CompanyLabelProjection> findAllProjectedBy();
}
