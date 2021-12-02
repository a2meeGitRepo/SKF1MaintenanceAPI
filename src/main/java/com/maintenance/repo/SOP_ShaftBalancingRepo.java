package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ShaftBalancing;

public interface SOP_ShaftBalancingRepo extends JpaRepository<SOP_ShaftBalancing, Integer>{

	@Query("From SOP_ShaftBalancing s where s.sopId=?1")
	Optional<SOP_ShaftBalancing> getStaffBalanceBySopId(int sopId);

}
