package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Company;
import com.soa.car_management.projection.CompanyDetailProjection;
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
                "\tcom.name,\n" +
                "    com.img,\n" +
                "    com.description,\n" +
                "    c.name as carname, \n" +
                "    c.image as carimage, \n" +
                "    concat(min(c.price),'-',max(c.price)) AS carprice, \n" +
                "    ANY_VALUE(c.version) as version \n" +
                "FROM \n" +
                "    car c\n" +
                "JOIN \n" +
                "    company com ON c.company_id = com.id \n" +
                "WHERE \n" +
                "    com.name = :name \n" +
                "GROUP BY \n" +
                "    c.name,\n" +
                "    com.name,\n" +
                "    com.img,\n" +
                "    com.description,\n" +
                "\tc.image\n"
        ,nativeQuery = true)
        List<CompanyDetailProjection> findProjectedByName(@Param("name") String name);

        Company findByName(String name);
}

