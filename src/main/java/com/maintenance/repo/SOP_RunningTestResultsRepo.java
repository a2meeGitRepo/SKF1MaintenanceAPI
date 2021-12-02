package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_RunningTestResult;
import com.maintenance.model.SOP_RunningTestResults;

public interface SOP_RunningTestResultsRepo extends JpaRepository<SOP_RunningTestResult, Integer>{

	@Query("from SOP_RunningTestResult r where r.sopId=?1")
	List<SOP_RunningTestResult> getRunningTestResultsBySOPId(int sopId);
}

	
