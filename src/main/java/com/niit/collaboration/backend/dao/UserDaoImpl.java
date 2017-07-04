/**
 * 
 */
package com.niit.collaboration.backend.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.backend.model.User;

/**
 * @author Deepika
 *
 */

@Repository("userDao")
@EnableTransactionManagement
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#create(com.niit.collaboration.
	 *      backend.model.User)
	 */
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#update(com.niit.collaboration.
	 *      backend.model.User)
	 */
	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#get(long)
	 */
	@Override
	public User get(long userId) {
		String hql = "from User where userId=" + userId;
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace(System.err);
		}
		return user;
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#get(java.lang.String)
	 */
	@Override
	public User get(String username) {
		String hql = "from User where username='" + username + "'";
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			//e.printStackTrace(System.err);
			System.err.println("No User Exists with Username: " + username);
		}
		return user;
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String hql = "from User";
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return users;
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#getAllExcept(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllExcept(long userId) {
		String hql = "from User where userId<>" + userId;
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return users;
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#exists(com.niit.collaboration.
	 *      backend.model.User)
	 */
	@Override
	public boolean exists(User auser) {
		User user = get(auser.getUsername());
		return (user != null);
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#authenticate(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) {
		String hql = "from User where username='" + username + "' and password='" + password + "'";
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace(System.err);
		}
		return (user != null);
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#setOnline(long)
	 */
	@Override
	public void setOnline(long userId) {
		String hql = "update User set isOnline=true where userId=" + userId;
		int result = sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result + " Record(s) Updated!");
	}

	/**
	 * 
	 * @see com.niit.collaboration.backend.dao.UserDao#setOffline(long)
	 */
	@Override
	public void setOffline(long userId) {
		String hql = "update User set isOnline=false where userId=" + userId;
		int result = sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result + " Record(s) Updated!");
	}

}
