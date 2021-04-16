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
    public LocalDate localDateTime;

    @NotNull(message = "Fat")
    public Double fat;

    @NotNull(message = "protein")
    public Double protein;

    @NotNull(message = "COMO")
    public Double COMO;

    @NotNull(message = "dry_substances")
    public Double dry_substances;

    @NotNull(message = "density")
    public Double density;

    @NotNull(message = "lactose")
    public Double lactose;

    @NotNull(message = "added_water")
    public Double added_water;

    @NotNull(message = "sample_temperature")
    public Double sample_temperature;

    @NotNull(message = "freezing_point")
    public Double freezing_point;

    @NotNull(message = "salts")
    public Double salts;

    @NotNull(message = "pH")
    public Double pH;

    @NotNull(message = "conductivity")
    public Double conductivity;
}
