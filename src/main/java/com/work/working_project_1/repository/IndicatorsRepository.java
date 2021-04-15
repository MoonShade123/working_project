package com.work.working_project_1.repository;

import com.work.working_project_1.model.FarmIndicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IndicatorsRepository extends JpaRepository<FarmIndicators, Long> {

    FarmIndicators findByCreationTime(final LocalDate localDate);
}
