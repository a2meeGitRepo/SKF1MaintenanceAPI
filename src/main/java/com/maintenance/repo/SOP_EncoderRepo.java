package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_Encoder;

public interface SOP_EncoderRepo extends JpaRepository<SOP_Encoder, Integer>{

	@Query("from SOP_Encoder e where e.sopId=?1")
	Optional<SOP_Encoder> getSpindleEncoderBySopId(int sopId);

}
