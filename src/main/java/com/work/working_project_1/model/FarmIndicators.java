package com.work.working_project_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "farmindicators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmIndicators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime = LocalDateTime.now();

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

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonIgnore
    private Farm farm;

}
