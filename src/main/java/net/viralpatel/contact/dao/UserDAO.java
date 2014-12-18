package net.viralpatel.contact.dao;

import net.viralpatel.contact.form.User;

public interface UserDAO {
	
	public boolean authenticateUser(User user);
	
	public User getUser(Long id);
	

}
