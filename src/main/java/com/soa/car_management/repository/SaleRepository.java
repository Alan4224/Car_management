package com.soa.car_management.repository;

import com.soa.car_management.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,String> {

}
