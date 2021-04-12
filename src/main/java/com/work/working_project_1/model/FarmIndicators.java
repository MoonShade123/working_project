package com.work.working_project_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.work.working_project_1.commons.IndicatorsNominal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "farmindicators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmIndicators {

    public static final Double MIN_VALUE = 0.5;
    public static final Double MAX_VALUE = 1.5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime = LocalDateTime.now();

    @NotNull(message = "Fat mush be filled")
    private Double fat;

    @NotNull(message = "Protein mush be filled")
    private Double protein;

    @NotNull(message = "COMO mush be filled")
    private Double COMO;

    @NotNull(message = "Dry substances mush be filled")
    private Double dry_substances;

    @NotNull(message = "Density mush be filled")
    private Double density;

    @NotNull(message = "Lactose mush be filled")
    private Double lactose;

    @NotNull(message = "Added water mush be filled")
    private Double added_water;

    @NotNull(message = "Sample temperature mush be filled")
    private Double sample_temperature;

    @NotNull(message = "Freezing point mush be filled")
    private Double freezing_point;

    @NotNull(message = "Salts mush be filled")
    private Double salts;

    @NotNull(message = "pH mush be filled")
    private Double pH;

    @NotNull(message = "Conductivity mush be filled")
    private Double conductivity;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonIgnore
    private Farm farm;

}
