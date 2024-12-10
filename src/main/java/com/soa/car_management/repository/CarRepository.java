package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Car;
import com.soa.car_management.projection.GetAllProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {

    @Query(value = "SELECT c.company,c.name,c.version,c.engine_type,c.price \n" +
            "FROM car c\n" +
            "ORDER BY c.company,c.name;"
            ,nativeQuery = true)
    List<GetAllProjection> getAllCar();

    @Query(value = "SELECT c.* from car c join company com on c.company_id = com.id where com.name = ?1 and c.name = ?2 ",nativeQuery = true)
    List<Car> getAllByCompanyAndName(String company, String name);

    @Query(value = "SELECT c.* from car c join company com on c.company_id = com.id where com.name = ?1 and c.name = ?2 and c.version = ?3 ",nativeQuery = true)
    List<Car> getAllByCompanyAndNameAndVersion(String company, String name,String version);

}
