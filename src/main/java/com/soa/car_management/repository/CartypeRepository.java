package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Cartype;
import com.soa.car_management.projection.AllCarTypeProj;
import com.soa.car_management.projection.CartypeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartypeRepository extends JpaRepository<Cartype,String> {
    List<CartypeProjection> findAllProjectedBy();
    Cartype findByName(String name);

    @Query(value = "SELECT ctp.name, ctp.img, ctp.description, c.name as carname, \n" +
            "c.image as carimage, concat(min(c.price),'-',max(c.price)) AS carprice, \n" +
            "ANY_VALUE(c.version) as version , ANY_VALUE(com.name) as company\n" +
            "FROM car c\n" +
            "JOIN company com on c.company_id = com.id\n" +
            "JOIN cartype ctp ON c.cartype_id = ctp.id \n" +
            "WHERE ctp.name = :name \n" +
            "GROUP BY c.name, ctp.name, ctp.img, ctp.description, c.image"
            ,nativeQuery = true)
    List<Object[]> findProjectedByName(@Param("name") String name);

    @Query(value = "SELECT s.id, s.name, s.description, s.img, COUNT(distinct c.name) as count\n" +
            "FROM cartype s\n" +
            "JOIN car c ON c.cartype_id = s.id\n" +
            "GROUP BY s.id, s.name, s.description, s.img;",nativeQuery = true)
    List<AllCarTypeProj> getAll();
}
