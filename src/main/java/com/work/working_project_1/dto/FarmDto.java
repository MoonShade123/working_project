package com.work.working_project_1.dto;

import com.work.working_project_1.model.FarmIndicators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String farmName;

    private LocalDateTime creationTime;

    private Collection<FarmIndicators> farmIndicators;

}
