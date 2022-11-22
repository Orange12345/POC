package com.changepond.executors.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the job_step_status database table.
 * 
 */
@Entity
@Table(name="job_step_status")
@NamedQuery(name="JobStepStatus.findAll", query="SELECT j FROM JobStepStatus j")
public class JobStepStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_step_status_id")
	private Integer jobStepStatusId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="execution_time")
	private Timestamp executionTime;

	@Column(name="is_success")
	private Boolean isSuccess;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to JobStep
	@ManyToOne
	@JoinColumn(name="job_step_id")
	private JobStep jobStep;

	public JobStepStatus() {
	}

	public Integer getJobStepStatusId() {
		return this.jobStepStatusId;
	}

	public void setJobStepStatusId(Integer jobStepStatusId) {
		this.jobStepStatusId = jobStepStatusId;
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

	public Timestamp getExecutionTime() {
		return this.executionTime;
	}

	public void setExecutionTime(Timestamp executionTime) {
		this.executionTime = executionTime;
	}

	public Boolean getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
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

	public JobStep getJobStep() {
		return this.jobStep;
	}

	public void setJobStep(JobStep jobStep) {
		this.jobStep = jobStep;
	}

}