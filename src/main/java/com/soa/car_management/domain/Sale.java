package com.soa.car_management.domain;

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

    private Integer month;
    private Integer north;
    private Integer central;
    private Integer south;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Car car;
}
