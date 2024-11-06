package com.soa.car_management.repository;

import com.soa.car_management.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    List<Car> findAllByCompany(String company);

    @Query("SELECT DISTINCT c.company FROM Car c")
    List<String> findAllCompanies();

    Car findByName(String name);

}
