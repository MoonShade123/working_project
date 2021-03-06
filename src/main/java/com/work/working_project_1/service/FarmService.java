package com.work.working_project_1.service;

import com.work.working_project_1.dto.AllFarmDto;
import com.work.working_project_1.dto.FarmDto;
import com.work.working_project_1.dto.dtoConverter.FromDtoConverter;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
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

    @PreAuthorize("hasRole('USER')")
    public Collection<AllFarmDto> getAll() {

        Collection<Farm> posts = this.farmRepository.findAllSortedByDateReverse();
        return posts.stream()
                .map(ToDtoConverter::allFarmToDto)
                .collect(Collectors.toList());

    }

    @PreAuthorize("hasRole('USER')")
    public FarmDto getByName(final String farmName) {

        Farm farm = this.farmRepository.findByFarmName(farmName);
        return ToDtoConverter.farmToDto(farm);

    }

    @PreAuthorize("hasRole('USER')")
    public void delete(final Long id) {
        this.farmRepository.deleteById(id);
    }
}
