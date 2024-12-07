package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CarDetailDTO;
import com.soa.car_management.projection.CompanyDetailDTO;
import com.soa.car_management.projection.CompanyLabelProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String>  {

        List<CompanyLabelProjection> findAllProjectedBy();

        @Query(value = "SELECT \n" +
                "    c.name AS name,\n" +
                "    c.img AS img,\n" +
                "    c.description AS description\n" +
                "FROM company c\n" +
                "WHERE c.name = ?1"
                ,nativeQuery = true)
        List<Object[]> findCompanyDetailByName(String name);

        @Query(value = "SELECT cr.name, cr.image, cr.price, CONCAT('/dong-xe/', cr.name) AS link "
                + "FROM company c "
                + "JOIN company_cars cc ON c.id = cc.company_id " +
                "JOIN car cr ON cc.cars_id = cr.id "
                + "WHERE c.name = ?1 "
                ,nativeQuery = true)
        List<Object[]> findCarDetailsByCompanyName(String name);

        Company findByName(String name);
}

