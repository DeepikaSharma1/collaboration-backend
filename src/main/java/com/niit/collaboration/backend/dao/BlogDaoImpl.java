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

import com.niit.collaboration.backend.model.Blog;

/**
 * @author Deepika
 *
 */
@Repository("blogDao")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#create(com.niit.collaboration.
	 *      backend.model.Blog)
	 */
	@Override
	public void create(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#update(com.niit.collaboration.
	 *      backend.model.Blog)
	 */
	@Override
	public void update(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#remove(com.niit.collaboration.
	 *      backend.model.Blog)
	 */
	@Override
	public void remove(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#get(long)
	 */
	@Override
	public Blog get(long blogId) {
		String hql = "from Blog where blogId=" + blogId;
		Blog blog = null;
		try {
			blog = (Blog) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace(System.err);
		}
		return blog;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#getNewBlogs()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getNewBlogs() {
		String hql = "from Blog where status='BLOG_NEW'";
		List<Blog> blogs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return blogs;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.BlogDao#getApprovedBlogs()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getApprovedBlogs() {
		String hql = "from Blog where status='BLOG_APPROVED'";
		List<Blog> blogs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return blogs;
	}

}
