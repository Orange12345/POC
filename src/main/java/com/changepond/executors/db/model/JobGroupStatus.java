package com.changepond.executors.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the job_group_status database table.
 * 
 */
@Entity
@Table(name="job_group_status")
@NamedQuery(name="JobGroupStatus.findAll", query="SELECT j FROM JobGroupStatus j")
public class JobGroupStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_group_status_id")
	private Integer jobGroupStatusId;

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

	//bi-directional many-to-one association to JobGroup
	@ManyToOne
	@JoinColumn(name="job_group_id")
	private JobGroup jobGroup;

	public JobGroupStatus() {
	}

	public Integer getJobGroupStatusId() {
		return this.jobGroupStatusId;
	}

	public void setJobGroupStatusId(Integer jobGroupStatusId) {
		this.jobGroupStatusId = jobGroupStatusId;
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

	public JobGroup getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(JobGroup jobGroup) {
		this.jobGroup = jobGroup;
	}

}