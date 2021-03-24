package com.work.working_project_1.service;

import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.dto.dtoConverter.FromDtoConverter;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
import com.work.working_project_1.exceptions.FarmException;
import com.work.working_project_1.model.Farm;
import com.work.working_project_1.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FarmService {

    private final FarmRepository farmRepository;

    @Autowired
    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public FarmDto create(final FarmDto farmDto) {

        Farm farm = FromDtoConverter.dtoToFarm(farmDto);
        farm.setCreationTime(LocalDateTime.now());
        this.farmRepository.save(farm);
        return ToDtoConverter.farmToDto(farm);

    }

    public Collection<FarmDto> getAll() {

        Collection<Farm> posts = this.farmRepository.findAllSortedByDateReverse();
        return posts.stream()
                .map(ToDtoConverter::farmToDto)
                .collect(Collectors.toList());

    }

    public FarmDto getByName(final String farmName) {

        Farm farm = this.farmRepository.findByFarmName(farmName);
        return ToDtoConverter.farmToDto(farm);

    }

    public FarmDto getById(final Long id) {

        Farm farm = this.farmRepository.findById(id).orElseThrow(
                () -> new FarmException("Can't get. Farm not found!"));
        return ToDtoConverter.farmToDto(farm);

    }

    @PreAuthorize("hasRole('USER')")
    public void delete(final Long id) {
        this.farmRepository.deleteById(id);
    }
}
