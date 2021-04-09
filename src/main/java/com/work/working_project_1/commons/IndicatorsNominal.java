package com.work.working_project_1.commons;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class IndicatorsNominal {

    private String name;
    private Double minValue;
    private Double maxValue;

    public IndicatorsNominal(String name, Double minValue, Double maxValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public HashMap<String, Object> toJson() {
        HashMap<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("min", minValue);
        json.put("max", maxValue);
        return json;
    }
}
