package com.work.working_project_1.repository;

import com.work.working_project_1.model.FarmIndicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IndicatorsRepository extends JpaRepository<FarmIndicators, Long> {

    FarmIndicators findByLocalDateTime(LocalDateTime localDateTime);

}
