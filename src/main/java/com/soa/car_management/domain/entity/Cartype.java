package com.soa.car_management.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Cartype {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String img;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String  description;

    @OneToMany
    List<Car> cars;
}
