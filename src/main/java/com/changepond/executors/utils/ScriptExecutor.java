package com.changepond.executors.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.changepond.executors.db.model.JobGroupStatus;
import com.changepond.executors.db.model.JobStep;
import com.changepond.executors.db.model.JobStepStatus;
import com.changepond.executors.db.repository.JobGroupStatusRespository;
import com.changepond.executors.db.repository.JobStepStatusRepository;

@Component
public class ScriptExecutor {

	public static final Logger LOGGER = LoggerFactory.getLogger(ScriptExecutor.class);
	@Autowired
	JobStepStatusRepository jobStepStatusRepository;
	@Autowired
	JobGroupStatusRespository jobGroupStatusRespository;
	boolean groupStatusFlag;
	public void executeScript(List<JobStep> jobList, int jobGroupId) throws IOException,IllegalStateException{

		ProcessBuilder processBuilder = new ProcessBuilder();
		Runtime r = Runtime.getRuntime();
		jobList.forEach(job ->{
			try {
				// Process process = Runtime.getRuntime().exec(scriptCommand);
				String stepCommand=job.getStepCommand();
				int extension_index=stepCommand.lastIndexOf('.');
				String extension=stepCommand.substring(extension_index);
				stepCommand=((extension.equalsIgnoreCase(".jar"))?"java -jar "+ 
						stepCommand
						:"bash " + stepCommand);
				processBuilder.command( 
						stepCommand);


				Process process =   r.exec(stepCommand);
				int exitStatus = process.waitFor();


				String line;
				LOGGER.info("***** Script execution Starts *****");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				StringBuilder builder = new StringBuilder();
				while ((line = bufferedReader.readLine()) != null) {
					LOGGER.info(line);
					builder.append(line);
					System.out.print("output : " + line);
					JobStepStatus jobStepStatus=objCreationForJobStepStatus(job,true);
					jobStepStatusRepository.save(jobStepStatus);
				}
				if (exitStatus != 0) {
					groupStatusFlag=true;
					bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
					while ((line = bufferedReader.readLine()) != null) {
						LOGGER.error(line);
						JobStepStatus jobStepStatus=objCreationForJobStepStatus(job,false);
						jobStepStatusRepository.save(jobStepStatus);
					}
				throw new IllegalStateException("Script exited abnormally");
				}
				System.out.print(builder.toString());
				LOGGER.info("***** Script executed successfully *****");

			} catch (InterruptedException | IOException e) {
				LOGGER.error("Error during script execution", e);
			}
		});
		updateJobGroupStatus(groupStatusFlag,jobGroupId);
	}
	
	private void updateJobGroupStatus(boolean groupStatusFlag, int jobGroupId) {
		JobGroupStatus jobGroupStatus=objCreationForJobStatus(jobGroupId,groupStatusFlag);
		jobGroupStatusRespository.save(jobGroupStatus);
	}

	public JobStepStatus objCreationForJobStepStatus(JobStep job, boolean flagStatus)
	{
		JobStepStatus jobStepStatus=new JobStepStatus();
		jobStepStatus.setIsSuccess(flagStatus);
		jobStepStatus.setJobStep(job);
		jobStepStatus.setCreatedBy("Babloo");
		jobStepStatus.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		jobStepStatus.setExecutionTime(Timestamp.valueOf(LocalDateTime.now()));
		return jobStepStatus;
		
	}
	
	public JobGroupStatus objCreationForJobStatus(int jobGroupId, boolean flagStatus)
	{
		JobGroupStatus jobGroupStatus=new JobGroupStatus();
		jobGroupStatus.setIsSuccess(flagStatus);
		jobGroupStatus.setJobGroupStatusId(jobGroupId);
		jobGroupStatus.setCreatedBy("Babloo");
		jobGroupStatus.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		jobGroupStatus.setExecutionTime(Timestamp.valueOf(LocalDateTime.now()));
		return jobGroupStatus;
		
	}
}
