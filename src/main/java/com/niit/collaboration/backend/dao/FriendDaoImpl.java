/**
 * 
 */
package com.niit.collaboration.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.backend.model.Friend;
import com.niit.collaboration.backend.model.RequestStatus;

/**
 * @author Deepika
 *
 */
@Repository("friendDao")
@EnableTransactionManagement
@Transactional
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#create(com.niit.collaboration.backend.model.Friend)
	 */
	@Override
	public void create(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		Friend frnd = new Friend();
		frnd.setUser(friend.getFriend());
		frnd.setFriend(friend.getUser());
		frnd.setStatus(RequestStatus.REQ_NEW);
		frnd.setOnline(false);
		
		session.saveOrUpdate(friend);
		session.saveOrUpdate(frnd);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#update(com.niit.collaboration.backend.model.Friend)
	 */
	@Override
	public void update(Friend friend) {
		sessionFactory.getCurrentSession().update(friend);
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#get(long, long)
	 */
	@Override
	public Friend get(long userId, long friendId) {
		String hql = "from Friend where userId=" + userId + " and friendId=" + friendId;
		Friend friend = null;
		try {
			friend = (Friend) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace(System.err);
		}
		return friend;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#getFriends(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> getFriends(long userId) {
		String hql = "from Friend where friendId=" + userId + " and status='REQ_ACCEPTED'";
		List<Friend> friends = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return friends;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#getRequests(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> getRequests(long userId) {
		String hql = "from Friend where friendId=" + userId + " and status='REQ_NEW'";
		List<Friend> friends = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return friends;
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#setOnline(long)
	 */
	@Override
	public void setOnline(long userId) {
		String hql = "update Friend set isOnline=true where friendId=" + userId;
		int result = sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result + " Record(s) Updated!");
	}

	/**
	 * 
	 * 
	 * @see com.niit.collaboration.backend.dao.FriendDao#setOffline(long)
	 */
	@Override
	public void setOffline(long userId) {
		String hql = "update Friend set isOnline=false where friendId=" + userId;
		int result = sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result + " Record(s) Updated!");
	}

}
