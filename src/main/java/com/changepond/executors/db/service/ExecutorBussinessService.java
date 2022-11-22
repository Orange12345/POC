package com.changepond.executors.db.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.executors.db.model.JobStep;
import com.changepond.executors.db.repository.JobStepRespository;
import com.changepond.executors.utils.ScriptExecutor;

@Service
public class ExecutorBussinessService {

  @Autowired
  private JobStepRespository jobStepRespository;
  
  @Autowired
  private ScriptExecutor scriptExecutor;

  public void executeComands(int jobGroupId) throws IllegalStateException, IOException{
	  List<JobStep> jobList=jobStepRespository.findjobStep(jobGroupId);
	   scriptExecutor.executeScript(jobList,jobGroupId);
  }
}
