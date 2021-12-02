package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ClampingSystemSensors;

public interface SOP_ClampingSystemSensorsRepo extends JpaRepository<SOP_ClampingSystemSensors, Integer>{

	@Query("From SOP_ClampingSystemSensors c where c.sopId=?1")
	Optional<SOP_ClampingSystemSensors> getSpindleCSSBySopId(int sopId);

}
