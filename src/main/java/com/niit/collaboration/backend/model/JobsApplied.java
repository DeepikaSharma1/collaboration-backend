/**
 * 
 */
package com.niit.collaboration.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Deepika
 *
 */

@Entity
@Table(name = "C_JOBS_APPLIED", schema = "SOCLDB")
public class JobsApplied {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long jobsAppliedId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "jobId")
	private Job job;
	@Temporal(TemporalType.DATE)
	private Date dateApplied;
	@Enumerated(EnumType.STRING)
	private JobStatus status;

	/**
	 * @return the jobsAppliedId
	 */
	public long getJobsAppliedId() {
		return jobsAppliedId;
	}

	/**
	 * @param jobsAppliedId
	 *            the jobsAppliedId to set
	 */
	public void setJobsAppliedId(long jobsAppliedId) {
		this.jobsAppliedId = jobsAppliedId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the dateApplied
	 */
	public Date getDateApplied() {
		return dateApplied;
	}

	/**
	 * @param dateApplied
	 *            the dateApplied to set
	 */
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	/**
	 * @return the status
	 */
	public JobStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(JobStatus status) {
		this.status = status;
	}

}
