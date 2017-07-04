/**
 * 
 */
package com.niit.collaboration.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.backend.model.Job;
import com.niit.collaboration.backend.model.JobsApplied;

/**
 * @author Deepika
 *
 */
@Repository("jobDao")
@EnableTransactionManagement
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#create(com.niit.collaboration.backend.model.Job)
	 */
	@Override
	public void create(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#update(com.niit.collaboration.backend.model.Job)
	 */
	@Override
	public void update(Job job) {
		sessionFactory.getCurrentSession().update(job);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#get(long)
	 */
	@Override
	public Job get(long jobId) {
		String hql = "from Job where jobId=" + jobId;
		Job job = null;
		try {
			job = (Job) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace(System.err);
		}
		return job;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getAll() {
		String hql = "from Job";
		List<Job> jobs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobs;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#getAll(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<JobsApplied> getAll(long userId) {
		String hql = "from JobsApplied where userId=" + userId;
		List<JobsApplied> jobsApplied = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobsApplied;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.JobDao#saveJobsApplied(com.niit.collaboration.backend.model.JobsApplied)
	 */
	@Override
	public void saveJobsApplied(JobsApplied jobsApplied) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobsApplied);
	}

}
