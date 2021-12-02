package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_LubricationSystemInspection;

public interface SOP_LubricationSystemInspectionRepo extends JpaRepository<SOP_LubricationSystemInspection, Integer> {

	@Query("From SOP_LubricationSystemInspection s where s.sopId=?1")
	Optional<SOP_LubricationSystemInspection> getSpindleLSIBySopId(int sopId);

}
