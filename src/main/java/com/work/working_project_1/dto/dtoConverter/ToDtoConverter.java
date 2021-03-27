package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.AllFarmDto;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.model.FarmIndicators;
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

    public static AllFarmDto allFarmToDto(final Farm farm) {
        return new AllFarmDto(
                farm.getId(),
                farm.getFarmName(),
                farm.getCreationTime()
        );
    }

    public static IndicatorsDto indicatorsToDto(final FarmIndicators farmIndicators) {
        return new IndicatorsDto(
                farmIndicators.getFarm().getId(),
                farmIndicators.getLocalDateTime(),
                farmIndicators.getFat(),
                farmIndicators.getProtein(),
                farmIndicators.getCOMO(),
                farmIndicators.getDry_substances(),
                farmIndicators.getDensity(),
                farmIndicators.getLactose(),
                farmIndicators.getAdded_water(),
                farmIndicators.getSample_temperature(),
                farmIndicators.getFreezing_point(),
                farmIndicators.getSalts(),
                farmIndicators.getPH(),
                farmIndicators.getConductivity()
        );
    }
}
