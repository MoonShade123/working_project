package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.model.Farm;

public class FromDtoConverter {
    public static Farm dtoToFarm(final FarmDto farmDto){
        Farm farm = new Farm();
        farm.setId(farmDto.getId());
        farm.setFarmName(farmDto.getFarmName());

        return farm;
    }
}
