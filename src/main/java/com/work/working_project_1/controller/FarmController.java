package com.work.working_project_1.controller;

import com.work.working_project_1.dto.AllFarmDto;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.service.FarmService;
import com.work.working_project_1.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<FarmDto> createFarm(@RequestBody final FarmDto farmDto) {
        return new ResponseEntity<>(this.farmService.create(farmDto), HttpStatus.OK);
    }

    @PostMapping("/add-indicators")
    public ResponseEntity<IndicatorsDto> createFarmIndicators(@RequestBody final IndicatorsDto indicatorsDto) {
        return new ResponseEntity<>(this.indicatorsService.create(indicatorsDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<AllFarmDto>> getAllFarms() {
        return new ResponseEntity<>(this.farmService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{farmName}")
    public ResponseEntity<FarmDto> getFarmByName(@PathVariable final String farmName) {
        return new ResponseEntity<>(this.farmService.getByName(farmName), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FarmDto> getFarmById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.farmService.getById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteFarmById(@PathVariable final Long id) {
        this.farmService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
