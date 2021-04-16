package com.work.working_project_1.controller;

import com.work.working_project_1.commons.IndicatorsNominal;
import com.work.working_project_1.commons.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/farms")
public class IndicatorsController {

    @GetMapping("/indicators-nominal")
    public ResponseEntity getIndicatorsNominal() {
        return new ResponseEntity<>(Utilities.nominal.stream().map(IndicatorsNominal::toJson).collect(Collectors.toList()), HttpStatus.OK);
    }
}
