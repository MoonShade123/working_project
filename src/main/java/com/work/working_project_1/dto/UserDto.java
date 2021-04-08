package com.work.working_project_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty
    private Long id;

    @NotBlank(message = "Username must be filled")
    private String username;

    @NotEmpty
    private LocalDateTime registrationTime;

    @NotBlank(message = "Phone number must be filled")
    private String phoneNumber;

}
