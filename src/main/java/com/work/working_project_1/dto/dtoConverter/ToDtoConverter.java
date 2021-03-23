package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.model.User;

import java.util.Collections;


public class ToDtoConverter {

    public static UserDto userToDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRegistrationTime(),
                user.getPhoneNumber());

    }

    public static FarmDto farmToDto(final Farm farm) {
        return new FarmDto(
                farm.getId(),
                farm.getFarmName(),
                farm.getCreationTime(),
                Collections.singleton(farm.getFarmIndicators())
        );
    }
}
