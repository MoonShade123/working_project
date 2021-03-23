package com.work.working_project_1.controller;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public ResponseEntity<FarmDto> createFarm(@RequestBody final FarmDto farmDto) {
        return new ResponseEntity<>(this.farmService.create(farmDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<FarmDto>> getAllFarms() {
        return new ResponseEntity<>(this.farmService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmDto> getFarmById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.farmService.getById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteFarmById(@PathVariable final Long id) {
        this.farmService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
