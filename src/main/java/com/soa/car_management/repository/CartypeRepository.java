package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.CartypeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartypeRepository extends JpaRepository<Cartype,String> {
    List<CartypeProjection> findAllProjectedBy();
}
