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

    @Query(value = "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Trên 20 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '2_ tỷ%' \n" +
            "UNION ALL\n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Từ 15 tỷ đến dưới 20 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '15 tỷ%' \n" +
            "OR c.price LIKE '16 tỷ%' \n" +
            "OR c.price LIKE '17 tỷ%' \n" +
            "OR c.price LIKE '18 tỷ%'\n" +
            "OR c.price LIKE '19 tỷ%'\n" +
            "UNION ALL\n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Từ 10 tỷ đến dưới 15 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '10 tỷ%' \n" +
            "OR c.price LIKE '11 tỷ%' \n" +
            "OR c.price LIKE '12 tỷ%' \n" +
            "OR c.price LIKE '13 tỷ%'\n" +
            "OR c.price LIKE '14 tỷ%'\n" +
            "UNION ALL\n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Từ 5 tỷ đến dưới 10 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '5 tỷ%' \n" +
            "OR c.price LIKE '6 tỷ%' \n" +
            "OR c.price LIKE '7 tỷ%' \n" +
            "OR c.price LIKE '8 tỷ%'\n" +
            "OR c.price LIKE '9 tỷ%'\n" +
            "UNION ALL\n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Từ 1 đến dưới 5 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '1 tỷ%' \n" +
            "OR c.price LIKE '2 tỷ%' \n" +
            "OR c.price LIKE '3 tỷ%' \n" +
            "OR c.price LIKE '4 tỷ%' \n" +
            "UNION ALL \n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Từ 500 triệu đến dưới 1 tỷ' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '5__ triệu%' \n" +
            "OR c.price LIKE '6__ triệu%' \n" +
            "OR c.price LIKE '7__ triệu%' \n" +
            "OR c.price LIKE '8__ triệu%'\n" +
            "OR c.price LIKE '9__ triệu%'\n" +
            "UNION ALL \n" +
            "SELECT SUM(s.north) + SUM(s.central) + SUM(s.south) AS totalSale, 'Dưới 500 triệu' AS priceRange \n" +
            "FROM Car c JOIN Sale s ON c.id = s.car_id \n" +
            "WHERE c.price LIKE '1__ triệu%' \n" +
            "OR c.price LIKE '2__ triệu%' \n" +
            "OR c.price LIKE '3__ triệu%' \n" +
            "OR c.price LIKE '4__ triệu%';"
            ,nativeQuery = true)
    Object[][] priceRange();
}
