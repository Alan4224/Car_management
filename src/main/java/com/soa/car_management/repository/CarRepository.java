package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    @Query("SELECT DISTINCT c.company FROM Car c")
    List<String> findAllCompanies();

    @Query("SELECT DISTINCT c.name FROM Car c   WHERE c.company = ?1")
    List<String> findAllName(String company);

    @Query("SELECT DISTINCT c.version FROM Car c   WHERE c.company = ?1 AND c.name = ?2")
    List<String> findAllVerSion(String company,String name);

    List<Car> findAllByCompany(String company);

    List<Car> findAllByCompanyAndName(String company, String name);

    List<Car> findAllByCompanyAndNameAndVersion(String company, String name,String version);

}
