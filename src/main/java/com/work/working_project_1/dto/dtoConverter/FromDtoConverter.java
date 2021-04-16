package com.work.working_project_1.dto.dtoConverter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.work.working_project_1.commons.IndicatorsNominal;
import com.work.working_project_1.commons.Utilities;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.exceptions.CustomValidationException;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.model.FarmIndicators;
import sun.plugin.dom.exception.NoModificationAllowedException;

import java.lang.reflect.Field;

public class FromDtoConverter {
    public static Farm dtoToFarm(final FarmDto farmDto){
        Farm farm = new Farm();
            farm.setFarmName(farmDto.getFarmName());

            return farm;
    }

    public static FarmIndicators dtoToIndicators(final IndicatorsDto indicatorsDto) throws IllegalAccessException, UnirestException {

        FarmIndicators farmIndicators = new FarmIndicators();
        farmIndicators.setFarm(farmIndicators.getFarm());
                for (IndicatorsNominal indicatorsNominal : Utilities.nominal) {
                    Field[] fields = IndicatorsDto.class.getDeclaredFields();
                    for (Field field : fields) {
                        if (field.getName().equals(indicatorsNominal.name)) {
                            field.setAccessible(true);
                            double value = (Double) field.get(indicatorsDto);
                            if(value < indicatorsNominal.minValue || value > indicatorsNominal.maxValue) {
                                Unirest.setTimeouts(0, 0);
                                HttpResponse<String> response = Unirest.post("https://reqres.in/api/register")
                                        .header("Content-Type", "application/json")
                                        .body("{\r\n    \"email\": \"eve.holt@reqres.in\",\r\n    \"password\": \"pistol\"\r\n}")
                                        .asString();
                                System.out.println("fuck");
                            } else {
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
                            }
                        }
                    }
                }

                return farmIndicators;
    }
}
