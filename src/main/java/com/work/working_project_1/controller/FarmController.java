package com.work.working_project_1.controller;

import com.work.working_project_1.commons.IndicatorsNominal;
import com.work.working_project_1.dto.AllFarmDto;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.service.FarmService;
import com.work.working_project_1.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;
    private final IndicatorsService indicatorsService;

    @Autowired
    public FarmController(FarmService farmService, IndicatorsService indicatorsService) {
        this.farmService = farmService;
        this.indicatorsService = indicatorsService;
    }

    @PostMapping
    public ResponseEntity<FarmDto> createFarm(@Valid @RequestBody final FarmDto farmDto) {
        return new ResponseEntity<>(this.farmService.create(farmDto), HttpStatus.OK);
    }

    @PostMapping("/add-indicators")
    public ResponseEntity<IndicatorsDto> createFarmIndicators(@Valid @RequestBody final IndicatorsDto indicatorsDto) {
        return new ResponseEntity<>(this.indicatorsService.create(indicatorsDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<AllFarmDto>> getAllFarms() {
        return new ResponseEntity<>(this.farmService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{farmName}")
    public ResponseEntity<FarmDto> getFarmByName(@PathVariable final String farmName) {
        return new ResponseEntity<>(this.farmService.getByName(farmName), HttpStatus.OK);
    }

    @GetMapping("/indicators-nominal/{indicatorName}")
    public ResponseEntity getIndicatorsNominal(@PathVariable String indicatorName, IndicatorsNominal indicatorsNominal) {
        indicatorsNominal.setName(indicatorName);
        indicatorsNominal.setMinValue(0.5);
        indicatorsNominal.setMaxValue(1.5);
        return new ResponseEntity<>(indicatorsNominal.toJson(),  HttpStatus.OK);
    }

    @GetMapping("/find-by-date/{localDateTime}")
    public ResponseEntity<IndicatorsDto> getIndicatorsByDate(@PathVariable final LocalDateTime localDateTime) {
        return new ResponseEntity<>(this.indicatorsService.getByDate(localDateTime), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFarmById(@Valid @PathVariable final Long id) {
        this.farmService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
