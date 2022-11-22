package com.changepond.executors.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.executors.db.model.JobGroupStatus;

@Repository
public interface JobGroupStatusRespository extends JpaRepository<JobGroupStatus, Integer> {

}
