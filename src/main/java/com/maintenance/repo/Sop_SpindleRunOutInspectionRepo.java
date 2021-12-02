package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_PowerCables;
import com.maintenance.model.SOP_SpindleRunOutInspection;

public interface Sop_SpindleRunOutInspectionRepo extends JpaRepository<SOP_SpindleRunOutInspection, Integer> {

	@Query("From SOP_SpindleRunOutInspection s where s.sopId=?1")
	Optional<SOP_SpindleRunOutInspection> getSpindleROIBySOPId(int sopId);
}
