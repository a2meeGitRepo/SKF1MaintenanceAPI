package com.maintenance.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_SealingInspection;


public interface SOP_SealingInspectionRepo extends JpaRepository<SOP_SealingInspection, Integer>{

	@Query("From SOP_SealingInspection s where s.sopId=?1")
	Optional<SOP_SealingInspection> getSpindleSIBySopId(int sopId);

	

}
