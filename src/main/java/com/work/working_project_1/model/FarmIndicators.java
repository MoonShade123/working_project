package com.work.working_project_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "farmindicators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmIndicators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime;

    private Double fat;

    private Double protein;

    private Double COMO;

    private Double dry_substances;

    private Double density;

    private Double lactose;

    private Double added_water;

    private Double sample_temperature;

    private Double freezing_point;

    private Double salts;

    private Double pH;

    private Double conductivity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "farm_id")
    private Farm farm;
}
