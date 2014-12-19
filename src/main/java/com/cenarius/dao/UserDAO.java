package com.cenarius.dao;

import com.cenarius.form.User;

public interface UserDAO {
	
	public boolean authenticateUser(User user);
	
	public User getUser(Long id);
	

}
