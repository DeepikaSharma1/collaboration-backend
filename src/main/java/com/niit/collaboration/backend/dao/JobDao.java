package com.niit.collaboration.backend.dao;

import java.util.List;

import com.niit.collaboration.backend.model.Job;
import com.niit.collaboration.backend.model.JobsApplied;

/**
 * 
 * @author Deepika
 *
 */
public interface JobDao {

	void create(Job job);
	
	void update(Job job);
	
	Job get(long jobId);
	
	List<Job> getAll();
	
	List<JobsApplied> getAll(long userId);
	
	void saveJobsApplied(JobsApplied jobsApplied);
	
}
