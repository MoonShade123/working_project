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
import java.time.LocalDate;

@Entity
@DynamicUpdate
@Table(name = "farmindicators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmIndicators {

    public static final Double MIN_VALUE_FAT = 0.5;
    public static final Double MAX_VALUE_FAT = 1.5;
    public static final Double MIN_VALUE_PROTEIN = 0.5;
    public static final Double MAX_VALUE_PROTEIN = 1.5;
    public static final Double MIN_VALUE_COMO = 0.5;
    public static final Double MAX_VALUE_COMO = 1.5;
    public static final Double MIN_VALUE_DRY_SUBSTANCES = 0.5;
    public static final Double MAX_VALUE_DRY_SUBSTANCES = 1.5;
    public static final Double MIN_VALUE_DENSITY = 0.5;
    public static final Double MAX_VALUE_DENSITY = 1.5;
    public static final Double MIN_VALUE_LACTOSE = 0.5;
    public static final Double MAX_VALUE_LACTOSE = 1.5;
    public static final Double MIN_VALUE_ADDED_WATER = 0.5;
    public static final Double MAX_VALUE_ADDED_WATER = 1.5;
    public static final Double MIN_VALUE_SAMPLE_TEMPERATURE = 0.5;
    public static final Double MAX_VALUE_SAMPLE_TEMPERATURE = 1.5;
    public static final Double MIN_VALUE_FREEZING_POINT = 0.5;
    public static final Double MAX_VALUE_FREEZING_POINT = 1.5;
    public static final Double MIN_VALUE_SALTS = 0.5;
    public static final Double MAX_VALUE_SALTS = 1.5;
    public static final Double MIN_VALUE_PH = 0.5;
    public static final Double MAX_VALUE_PH = 1.5;
    public static final Double MIN_VALUE_CONDUCTIVITY = 0.5;
    public static final Double MAX_VALUE_CONDUCTIVITY = 1.5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate creationTime;

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
