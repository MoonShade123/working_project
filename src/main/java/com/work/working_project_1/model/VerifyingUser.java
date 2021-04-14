package com.work.working_project_1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
public class VerifyingUser {

    @NotBlank(message = "Field 'Phone number' must be filled")
    private String phoneNumber;

    @NotBlank(message = "Field 'code' must be filled")
    private String code;

    @NotBlank(message = "Field 'password' must be filled")
    private String password;
}
