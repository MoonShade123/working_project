package com.work.working_project_1.repository;

import com.work.working_project_1.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query("from Farm f order by f.creationTime desc")
    Collection<Farm> findAllSortedByDateReverse();

//    Farm findByFarmName(final String farmName);

}
