package com.changepond.executors.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_group database table.
 * 
 */
@Entity
@Table(name="job_group")
@NamedQuery(name="JobGroup.findAll", query="SELECT j FROM JobGroup j")
public class JobGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_group_id")
	private Integer jobGroupId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="dependent_job_group_id")
	private Integer dependentJobGroupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="restart_from_begin")
	private Boolean restartFromBegin;

	//bi-directional many-to-one association to JobGroupStatus
	@OneToMany(mappedBy="jobGroup")
	private List<JobGroupStatus> jobGroupStatuses;

	//bi-directional many-to-one association to JobStep
	@OneToMany(mappedBy="jobGroup")
	private List<JobStep> jobSteps;

	public JobGroup() {
	}

	public Integer getJobGroupId() {
		return this.jobGroupId;
	}

	public void setJobGroupId(Integer jobGroupId) {
		this.jobGroupId = jobGroupId;
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

	public Integer getDependentJobGroupId() {
		return this.dependentJobGroupId;
	}

	public void setDependentJobGroupId(Integer dependentJobGroupId) {
		this.dependentJobGroupId = dependentJobGroupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Boolean getRestartFromBegin() {
		return this.restartFromBegin;
	}

	public void setRestartFromBegin(Boolean restartFromBegin) {
		this.restartFromBegin = restartFromBegin;
	}

	public List<JobGroupStatus> getJobGroupStatuses() {
		return this.jobGroupStatuses;
	}

	public void setJobGroupStatuses(List<JobGroupStatus> jobGroupStatuses) {
		this.jobGroupStatuses = jobGroupStatuses;
	}

	public JobGroupStatus addJobGroupStatus(JobGroupStatus jobGroupStatus) {
		getJobGroupStatuses().add(jobGroupStatus);
		jobGroupStatus.setJobGroup(this);

		return jobGroupStatus;
	}

	public JobGroupStatus removeJobGroupStatus(JobGroupStatus jobGroupStatus) {
		getJobGroupStatuses().remove(jobGroupStatus);
		jobGroupStatus.setJobGroup(null);

		return jobGroupStatus;
	}

	public List<JobStep> getJobSteps() {
		return this.jobSteps;
	}

	public void setJobSteps(List<JobStep> jobSteps) {
		this.jobSteps = jobSteps;
	}

	public JobStep addJobStep(JobStep jobStep) {
		getJobSteps().add(jobStep);
		jobStep.setJobGroup(this);

		return jobStep;
	}

	public JobStep removeJobStep(JobStep jobStep) {
		getJobSteps().remove(jobStep);
		jobStep.setJobGroup(null);

		return jobStep;
	}

}