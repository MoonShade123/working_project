package com.work.working_project_1.controller;

import com.work.working_project_1.commons.IndicatorsNominal;
import com.work.working_project_1.model.FarmIndicators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farms")
public class IndicatorsController {

    @GetMapping(value = "/indicators-nominal")
    public ResponseEntity getNominal(IndicatorsNominal indicatorsNominal) {
        return new ResponseEntity<>(indicatorsNominal.toJson(), HttpStatus.OK);
    }
}
