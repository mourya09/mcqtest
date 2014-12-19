package com.cenarius.dao;

import java.util.List;

import com.cenarius.form.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
