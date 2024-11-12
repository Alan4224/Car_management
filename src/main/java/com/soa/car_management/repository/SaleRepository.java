package com.soa.car_management.repository;

import com.soa.car_management.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale,String> {
    @Query(value = "SELECT c.company, SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale " +
            "FROM Car c JOIN Sale s ON c.id = s.car_id " +
            "WHERE s.month = ?1 " +
            "GROUP BY c.company " +
            "ORDER BY totalSale DESC " +
            "LIMIT 10"
            , nativeQuery = true)
    Object[][] topMonth(Integer month);

    @Query(value = "SELECT \n" +
            "    CASE \n" +
            "        WHEN COALESCE(c.fuel_type, 'Xăng') IN ('Dầu', 'Dầu (Diesel)', 'Diesel') THEN 'Dầu (Diesel)'\n" +
            "        WHEN COALESCE(c.fuel_type, 'Xăng') IN ('Xăng+Điện', 'Xăng lai Hybrid') THEN 'Xăng lai Hybrid'\n" +
            "        WHEN COALESCE(c.fuel_type, 'Xăng') = 'Xăng' THEN 'Xăng'\n" +
            "        ELSE COALESCE(c.fuel_type, 'Unknown')\n" +
            "    END AS normalized_fuel_type, \n" +
            "    SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale\n" +
            "FROM Car c \n" +
            "JOIN Sale s ON c.id = s.car_id\n" +
            "GROUP BY normalized_fuel_type\n" +
            "ORDER BY totalSale DESC;"
            , nativeQuery = true)
    Object[][] saleFuel();

    @Query(value="SELECT c.company, c.name, SUM(s.north) AS north , SUM(s.central) AS central , SUM(s.south) AS south, \n" +
            "SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale\n" +
            "FROM Car c\n" +
            "JOIN Sale s ON c.id = s.car_id\n" +
            "GROUP BY c.company, c.name\n" +
            "ORDER BY totalSale DESC\n" +
            "LIMIT 5;"
            , nativeQuery = true)
    Object[][] salePlace();
}
