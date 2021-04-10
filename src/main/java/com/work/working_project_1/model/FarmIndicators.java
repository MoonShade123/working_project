package com.work.working_project_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.work.working_project_1.commons.IndicatorsNominal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Fat mush be filled")

    private Double fat;

    @NotBlank(message = "Protein mush be filled")
    private Double protein;

    @NotBlank(message = "COMO mush be filled")
    private Double COMO;

    @NotBlank(message = "Dry substances mush be filled")
    private Double dry_substances;

    @NotBlank(message = "Density mush be filled")
    private Double density;

    @NotBlank(message = "Lactose mush be filled")
    private Double lactose;

    @NotBlank(message = "Added water mush be filled")
    private Double added_water;

    @NotBlank(message = "Sample temperature mush be filled")
    private Double sample_temperature;

    @NotBlank(message = "Freezing point mush be filled")
    private Double freezing_point;

    @NotBlank(message = "Salts mush be filled")
    private Double salts;

    @NotBlank(message = "pH mush be filled")
    private Double pH;

    @NotBlank(message = "Conductivity mush be filled")
    private Double conductivity;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonIgnore
    private Farm farm;

}
