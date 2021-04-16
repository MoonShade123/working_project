package com.work.working_project_1.repository;

import com.work.working_project_1.model.FarmIndicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IndicatorsRepository extends JpaRepository<FarmIndicators, Long> {

    @Query(value = "SELECT f from FarmIndicators f where f.farm.id = ?1 and f.creationTime = ?2")
    FarmIndicators findByCreationTimeAndFarm(final Long id, final LocalDate creationTime);
}
