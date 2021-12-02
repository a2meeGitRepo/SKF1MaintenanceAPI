package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_DrawbarSpringInspection;

public interface SOP_DrawbarSpringInspectionRepo extends JpaRepository<SOP_DrawbarSpringInspection, Integer>{

	@Query("from SOP_DrawbarSpringInspection s where s.sopId=?1")
	Optional<SOP_DrawbarSpringInspection> getSpindleDSIBySopId(int sopId);

}
