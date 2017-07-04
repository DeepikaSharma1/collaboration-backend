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

import com.niit.collaboration.backend.model.Event;

/**
 * @author Deepika
 *
 */
@Repository("eventDao")
@EnableTransactionManagement
@Transactional
public class EventDaoImpl implements EventDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.EventDao#create(com.niit.collaboration.backend.model.Event)
	 */
	@Override
	public void create(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.EventDao#update(com.niit.collaboration.backend.model.Event)
	 */
	@Override
	public void update(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.EventDao#get(long)
	 */
	@Override
	public Event get(long eventId) {
		String hql = "from Event where eventId=" + eventId;
		Event event = null;
		try {
			event = (Event) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace(System.err);
		}
		return event;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.EventDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getAll() {
		String hql = "from Event";
		List<Event> events = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return events;
	}

}
