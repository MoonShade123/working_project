package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.model.User;


public class ToDtoConverter {

    public static UserDto userToDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRegistrationTime(),
                user.getPhoneNumber());

    }
}
