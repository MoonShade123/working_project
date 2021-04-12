package com.work.working_project_1.dto;

import com.work.working_project_1.model.FarmIndicators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    @ApiModelProperty(hidden = true)
    private Long id;

    @NotBlank(message = "Farm name must be filled")
    private String farmName;

    @ApiModelProperty(hidden = true)
    private LocalDateTime creationTime;

    @ApiModelProperty(hidden = true)
    private Collection<FarmIndicators> farmIndicators;

}
