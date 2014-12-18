/**
 * 
 */
package net.viralpatel.contact.service.impl;

import net.viralpatel.contact.dao.UserDAO;
import net.viralpatel.contact.form.User;
import net.viralpatel.contact.service.UserService;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nex6uyu
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.service.UserService#authenticateUser(net.viralpatel.contact.form.User)
	 */
	@Transactional(readOnly = true)
	@Override
	public boolean authenticateUser(User user) throws Exception {
		
			return userDAO.authenticateUser(user);			
		
	}

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.service.UserService#getUser(java.lang.Long)
	 */
	
	@Transactional(readOnly = true)
	@Override
	public User getUser(Long id) throws HibernateException {
	
		return userDAO.getUser(id);
	}

}
