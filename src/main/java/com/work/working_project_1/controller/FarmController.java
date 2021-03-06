package com.work.working_project_1.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.work.working_project_1.dto.AllFarmDto;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.model.FarmIndicators;
import com.work.working_project_1.service.FarmService;
import com.work.working_project_1.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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
    public ResponseEntity<IndicatorsDto> createFarmIndicators(@Valid @RequestBody final IndicatorsDto indicatorsDto) throws IllegalAccessException, UnirestException {
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

    @GetMapping("/find/{id}/{localDate}")
    public ResponseEntity<FarmIndicators> getIndicatorsByDate(@PathVariable final Long id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate localDate) {
        return new ResponseEntity<>(this.indicatorsService.findByIdAndDate(id, localDate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFarmById(@Valid @PathVariable final Long id) {
        this.farmService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
