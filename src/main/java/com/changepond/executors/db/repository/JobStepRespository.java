package com.changepond.executors.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.changepond.executors.db.model.JobStep;

@Repository
public interface JobStepRespository extends JpaRepository<JobStep, Integer> {
	
	@Query(value="select * from job_step where job_group_id=?1",nativeQuery=true)
	public List<JobStep> findjobStep(int jobgGroupId);
	
}