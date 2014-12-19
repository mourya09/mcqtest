/**
 * 
 */
package com.cenarius.service;

import com.cenarius.form.User;

import org.hibernate.HibernateException;

/**
 * @author nex6uyu
 *
 */
public interface UserService {
	/**
	 * Method will authenticate as well as set the Usertoken in the User object
	 * */
	public boolean authenticateUser(User user) throws Exception;
	
	
	/**
	 * Method will fetch the user information from the database
	 * */
	public User getUser(Long id) throws HibernateException;
}
