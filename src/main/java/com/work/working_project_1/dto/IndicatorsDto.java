package com.work.working_project_1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsDto {

    private Long farmId;

    @ApiModelProperty(hidden = true)
    private LocalDate localDateTime;

    @NotNull(message = "Fat")
    private Double fat;

    @NotNull(message = "protein")
    private Double protein;

    @NotNull(message = "COMO")
    private Double COMO;

    @NotNull(message = "dry_substances")
    private Double dry_substances;

    @NotNull(message = "density")
    private Double density;

    @NotNull(message = "lactose")
    private Double lactose;

    @NotNull(message = "added_water")
    private Double added_water;

    @NotNull(message = "sample_temperature")
    private Double sample_temperature;

    @NotNull(message = "freezing_point")
    private Double freezing_point;

    @NotNull(message = "salts")
    private Double salts;

    @NotNull(message = "pH")
    private Double pH;

    @NotNull(message = "conductivity")
    private Double conductivity;
}
