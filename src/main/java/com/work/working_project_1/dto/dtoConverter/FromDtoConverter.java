package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.model.FarmIndicators;

public class FromDtoConverter {
    public static Farm dtoToFarm(final FarmDto farmDto){
        Farm farm = new Farm();
            farm.setId(farmDto.getId());
            farm.setFarmName(farmDto.getFarmName());

            return farm;
    }

    public static FarmIndicators dtoToIndicators(final IndicatorsDto indicatorsDto) {
        FarmIndicators farmIndicators = new FarmIndicators();
                farmIndicators.setFat(indicatorsDto.getFat());
                farmIndicators.setProtein(indicatorsDto.getProtein());
                farmIndicators.setCOMO(indicatorsDto.getCOMO());
                farmIndicators.setDry_substances(indicatorsDto.getDry_substances());
                farmIndicators.setDensity(indicatorsDto.getDensity());
                farmIndicators.setLactose(indicatorsDto.getLactose());
                farmIndicators.setAdded_water(indicatorsDto.getAdded_water());
                farmIndicators.setSample_temperature(indicatorsDto.getSample_temperature());
                farmIndicators.setFreezing_point(indicatorsDto.getFreezing_point());
                farmIndicators.setSalts(indicatorsDto.getSalts());
                farmIndicators.setPH(indicatorsDto.getPH());
                farmIndicators.setConductivity(indicatorsDto.getConductivity());

                return farmIndicators;
    }
}
