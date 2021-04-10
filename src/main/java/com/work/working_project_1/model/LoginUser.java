package com.work.working_project_1.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUser {

    @NotBlank(message = "Field 'username' must be filled")
    private String username;

    @NotBlank(message = "Field 'password' must be filled")
    private String password;

}
