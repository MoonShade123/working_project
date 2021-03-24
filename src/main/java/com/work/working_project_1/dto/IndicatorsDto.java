package com.work.working_project_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsDto {

    private LocalDateTime localDateTime;

    @NotEmpty
    private Double fat;

    @NotEmpty
    private Double protein;

    @NotEmpty
    private Double COMO;

    @NotEmpty
    private Double dry_substances;

    @NotEmpty
    private Double density;

    @NotEmpty
    private Double lactose;

    @NotEmpty
    private Double added_water;

    @NotEmpty
    private Double sample_temperature;

    @NotEmpty
    private Double freezing_point;

    @NotEmpty
    private Double salts;

    @NotEmpty
    private Double pH;

    @NotEmpty
    private Double conductivity;
}
