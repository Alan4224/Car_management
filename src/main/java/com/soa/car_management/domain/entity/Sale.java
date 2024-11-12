package com.soa.car_management.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer month; // Tháng
    private Integer north; // Bắc
    private Integer central; // Trung
    private Integer south; // Nam

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Car car;
}
