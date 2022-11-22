package com.changepond.executors.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_step database table.
 * 
 */
@Entity
@Table(name="job_step")
@NamedQuery(name="JobStep.findAll", query="SELECT j FROM JobStep j")
public class JobStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_step_id")
	private Integer jobStepId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="execution_order_number")
	private Integer executionOrderNumber;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="step_command")
	private String stepCommand;

	@Column(name="step_name")
	private String stepName;

	@Column(name="type_of_command")
	private String typeOfCommand;

	//bi-directional many-to-one association to JobGroup
	@ManyToOne
	@JoinColumn(name="job_group_id")
	private JobGroup jobGroup;

	//bi-directional many-to-one association to JobStepStatus
	@OneToMany(mappedBy="jobStep")
	private List<JobStepStatus> jobStepStatuses;

	public JobStep() {
	}

	public Integer getJobStepId() {
		return this.jobStepId;
	}

	public void setJobStepId(Integer jobStepId) {
		this.jobStepId = jobStepId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getExecutionOrderNumber() {
		return this.executionOrderNumber;
	}

	public void setExecutionOrderNumber(Integer executionOrderNumber) {
		this.executionOrderNumber = executionOrderNumber;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStepCommand() {
		return this.stepCommand;
	}

	public void setStepCommand(String stepCommand) {
		this.stepCommand = stepCommand;
	}

	public String getStepName() {
		return this.stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getTypeOfCommand() {
		return this.typeOfCommand;
	}

	public void setTypeOfCommand(String typeOfCommand) {
		this.typeOfCommand = typeOfCommand;
	}

	public JobGroup getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(JobGroup jobGroup) {
		this.jobGroup = jobGroup;
	}

	public List<JobStepStatus> getJobStepStatuses() {
		return this.jobStepStatuses;
	}

	public void setJobStepStatuses(List<JobStepStatus> jobStepStatuses) {
		this.jobStepStatuses = jobStepStatuses;
	}

	public JobStepStatus addJobStepStatus(JobStepStatus jobStepStatus) {
		getJobStepStatuses().add(jobStepStatus);
		jobStepStatus.setJobStep(this);

		return jobStepStatus;
	}

	public JobStepStatus removeJobStepStatus(JobStepStatus jobStepStatus) {
		getJobStepStatuses().remove(jobStepStatus);
		jobStepStatus.setJobStep(null);

		return jobStepStatus;
	}

}