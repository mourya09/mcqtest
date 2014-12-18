/**
 * 
 */
package net.viralpatel.contact.dao.impl;

import java.io.Serializable;
import java.util.List;

import net.viralpatel.contact.dao.UserDAO;
import net.viralpatel.contact.form.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author nex6uyu
 *
 */

@Repository
public class UserDAOImpl implements UserDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894503040542212937L;
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see net.viralpatel.contact.dao.UserDAO#authenticateUser(net.viralpatel.contact.form.User)
	 */
	@Override
	public boolean authenticateUser(User user) {
		boolean result = false;
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"Select * from User where userName= :userName and userPassword= :userPassword").addEntity(User.class);		
		query.setParameter("userName", user.getUserName());
		query.setParameter("userPassword", user.getUserPassword());
		
		List<User> list = query.list();
		if(list != null && list.size() > 0 )
		{
			result = true;
			user.setUserToken(list.get(0).getUserToken());
			user.setId(list.get(0).getId());
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.dao.UserDAO#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long id) {
		User user = null;
		user =(User) sessionFactory.getCurrentSession().get(User.class, id);		
		
		return user;
	}

}
