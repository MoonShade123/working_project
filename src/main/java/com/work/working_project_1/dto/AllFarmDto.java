package com.work.working_project_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllFarmDto {
    private Long id;

    @NotEmpty
    private String farmName;

    private LocalDateTime creationTime;
}
