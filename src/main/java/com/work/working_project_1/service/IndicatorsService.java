package com.work.working_project_1.service;

import com.work.working_project_1.dto.IndicatorsDto;
import com.work.working_project_1.dto.dtoConverter.FromDtoConverter;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
import com.work.working_project_1.model.FarmIndicators;
import com.work.working_project_1.repository.FarmRepository;
import com.work.working_project_1.repository.IndicatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IndicatorsService {

    private final FarmRepository farmRepository;
    private final IndicatorsRepository indicatorsRepository;

    @Autowired
    public IndicatorsService(FarmRepository farmRepository, IndicatorsRepository indicatorsRepository) {
        this.farmRepository = farmRepository;
        this.indicatorsRepository = indicatorsRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public IndicatorsDto create(final IndicatorsDto indicatorsDto) {

        FarmIndicators farmIndicators = FromDtoConverter.dtoToIndicators(indicatorsDto);
        farmIndicators.setFarm(farmRepository.getOne(indicatorsDto.getFarmId()));
        farmIndicators.setLocalDateTime(LocalDateTime.now());
        this.indicatorsRepository.save(farmIndicators);
        return ToDtoConverter.indicatorsToDto(farmIndicators);

    }

    @PreAuthorize("hasRole('USER')")
    public IndicatorsDto getByDate(final LocalDateTime localDateTime) {
        FarmIndicators farmIndicators = this.indicatorsRepository.getByLocalDateTime(localDateTime);
        return ToDtoConverter.indicatorsToDto(farmIndicators);
    }
}
