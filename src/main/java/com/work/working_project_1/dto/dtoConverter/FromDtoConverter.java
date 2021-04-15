package com.work.working_project_1.dto.dtoConverter;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.exceptions.CustomValidationException;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.model.FarmIndicators;

public class FromDtoConverter {
    public static Farm dtoToFarm(final FarmDto farmDto){
        Farm farm = new Farm();
            farm.setFarmName(farmDto.getFarmName());

            return farm;
    }

    public static FarmIndicators dtoToIndicators(final IndicatorsDto indicatorsDto) {

        FarmIndicators farmIndicators = new FarmIndicators();

                farmIndicators.setFarm(farmIndicators.getFarm());
                if (indicatorsDto.getFat() >= FarmIndicators.MIN_VALUE_FAT && indicatorsDto.getFat() <= FarmIndicators.MAX_VALUE_FAT) {
                    farmIndicators.setFat(indicatorsDto.getFat());
                } else if (indicatorsDto.getFat() < FarmIndicators.MIN_VALUE_FAT) {
                    throw new CustomValidationException("Fat is lower that needed");
                } else if (indicatorsDto.getFat() > FarmIndicators.MAX_VALUE_FAT) {
                    throw new CustomValidationException("Fat is bigger that needed");
                }

                if (indicatorsDto.getProtein() >= FarmIndicators.MIN_VALUE_PROTEIN && indicatorsDto.getProtein() <= FarmIndicators.MAX_VALUE_PROTEIN) {
                    farmIndicators.setProtein(indicatorsDto.getProtein());
                } else if (indicatorsDto.getProtein() < FarmIndicators.MIN_VALUE_PROTEIN) {
                    throw new CustomValidationException("Protein is lower that needed");
                } else if (indicatorsDto.getProtein() > FarmIndicators.MAX_VALUE_PROTEIN) {
                    throw new CustomValidationException("Protein is bigger that needed");
                }

                if (indicatorsDto.getCOMO() >= FarmIndicators.MIN_VALUE_COMO && indicatorsDto.getCOMO() <= FarmIndicators.MAX_VALUE_COMO) {
                    farmIndicators.setCOMO(indicatorsDto.getCOMO());
                } else if (indicatorsDto.getCOMO() < FarmIndicators.MIN_VALUE_COMO) {
                    throw new CustomValidationException("COMO is lower that needed");
                } else if (indicatorsDto.getCOMO() > FarmIndicators.MAX_VALUE_COMO) {
                    throw new CustomValidationException("COMO is bigger that needed");
                }

                if (indicatorsDto.getDry_substances() >= FarmIndicators.MIN_VALUE_DRY_SUBSTANCES && indicatorsDto.getDry_substances() <= FarmIndicators.MAX_VALUE_DRY_SUBSTANCES) {
                    farmIndicators.setDry_substances(indicatorsDto.getDry_substances());
                } else if (indicatorsDto.getDry_substances() < FarmIndicators.MIN_VALUE_DRY_SUBSTANCES) {
                    throw new CustomValidationException("Dry substances is lower that needed");
                } else if (indicatorsDto.getDry_substances() > FarmIndicators.MAX_VALUE_DRY_SUBSTANCES) {
                    throw new CustomValidationException("Dry substances is bigger that needed");
                }

                if (indicatorsDto.getDensity() >= FarmIndicators.MIN_VALUE_DENSITY && indicatorsDto.getDensity() <= FarmIndicators.MAX_VALUE_DENSITY) {
                    farmIndicators.setDensity(indicatorsDto.getDensity());
                } else if (indicatorsDto.getDensity() < FarmIndicators.MIN_VALUE_DENSITY) {
                    throw new CustomValidationException("Density is lower that needed");
                } else if (indicatorsDto.getDensity() > FarmIndicators.MAX_VALUE_DENSITY) {
                    throw new CustomValidationException("Density is bigger that needed");
                }

                if (indicatorsDto.getLactose() >= FarmIndicators.MIN_VALUE_LACTOSE && indicatorsDto.getLactose() <= FarmIndicators.MAX_VALUE_LACTOSE) {
                    farmIndicators.setLactose(indicatorsDto.getLactose());
                } else if (indicatorsDto.getLactose() < FarmIndicators.MIN_VALUE_LACTOSE) {
                    throw new CustomValidationException("Lactose is lower that needed");
                } else if (indicatorsDto.getLactose() > FarmIndicators.MAX_VALUE_LACTOSE) {
                    throw new CustomValidationException("Lactose is bigger that needed");
                }

                if (indicatorsDto.getAdded_water() >= FarmIndicators.MIN_VALUE_ADDED_WATER && indicatorsDto.getAdded_water() <= FarmIndicators.MAX_VALUE_ADDED_WATER) {
                    farmIndicators.setAdded_water(indicatorsDto.getAdded_water());
                } else if (indicatorsDto.getAdded_water() < FarmIndicators.MIN_VALUE_ADDED_WATER) {
                    throw new CustomValidationException("Added water is lower that needed");
                } else if (indicatorsDto.getAdded_water() > FarmIndicators.MAX_VALUE_ADDED_WATER) {
                    throw new CustomValidationException("Added water is bigger that needed");
                }

                if (indicatorsDto.getSample_temperature() >= FarmIndicators.MIN_VALUE_SAMPLE_TEMPERATURE && indicatorsDto.getSample_temperature() <= FarmIndicators.MAX_VALUE_SAMPLE_TEMPERATURE) {
                    farmIndicators.setSample_temperature(indicatorsDto.getSample_temperature());
                } else if (indicatorsDto.getFat() < FarmIndicators.MIN_VALUE_SAMPLE_TEMPERATURE) {
                    throw new CustomValidationException("Sample temperature is lower that needed");
                } else if (indicatorsDto.getFat() > FarmIndicators.MAX_VALUE_SAMPLE_TEMPERATURE) {
                    throw new CustomValidationException("Sample temperature is bigger that needed");
                }

                if (indicatorsDto.getFreezing_point() >= FarmIndicators.MIN_VALUE_FREEZING_POINT && indicatorsDto.getFreezing_point() <= FarmIndicators.MAX_VALUE_FREEZING_POINT) {
                    farmIndicators.setFreezing_point(indicatorsDto.getFreezing_point());
                } else if (indicatorsDto.getFreezing_point() < FarmIndicators.MIN_VALUE_FREEZING_POINT) {
                    throw new CustomValidationException("Freezing point is lower that needed");
                } else if (indicatorsDto.getFreezing_point() > FarmIndicators.MAX_VALUE_FREEZING_POINT) {
                    throw new CustomValidationException("Freezing point is bigger that needed");
                }

                if (indicatorsDto.getSalts() >= FarmIndicators.MIN_VALUE_SALTS && indicatorsDto.getSalts() <= FarmIndicators.MAX_VALUE_SALTS) {
                    farmIndicators.setSalts(indicatorsDto.getSalts());
                } else if (indicatorsDto.getSalts() < FarmIndicators.MIN_VALUE_SALTS) {
                    throw new CustomValidationException("Salts is lower that needed");
                } else if (indicatorsDto.getSalts() > FarmIndicators.MAX_VALUE_SALTS) {
                    throw new CustomValidationException("Salts is bigger that needed");
                }

                if (indicatorsDto.getPH() >= FarmIndicators.MIN_VALUE_PH && indicatorsDto.getPH() <= FarmIndicators.MAX_VALUE_PH) {
                    farmIndicators.setPH(indicatorsDto.getPH());
                } else if (indicatorsDto.getPH() < FarmIndicators.MIN_VALUE_PH) {
                    throw new CustomValidationException("pH is lower that needed");
                } else if (indicatorsDto.getPH() > FarmIndicators.MAX_VALUE_PH) {
                    throw new CustomValidationException("pH is bigger that needed");
                }
                if (indicatorsDto.getConductivity() >= FarmIndicators.MIN_VALUE_CONDUCTIVITY && indicatorsDto.getConductivity() <= FarmIndicators.MAX_VALUE_CONDUCTIVITY) {
                    farmIndicators.setConductivity(indicatorsDto.getConductivity());
                } else if (indicatorsDto.getConductivity() < FarmIndicators.MIN_VALUE_CONDUCTIVITY) {
                    throw new CustomValidationException("Conductivity is lower that needed");
                } else if (indicatorsDto.getConductivity() > FarmIndicators.MAX_VALUE_CONDUCTIVITY) {
                    throw new CustomValidationException("Conductivity is bigger that needed");
                }

                return farmIndicators;
    }
}
