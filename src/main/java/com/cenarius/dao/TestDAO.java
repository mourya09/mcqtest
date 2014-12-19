/**
 * 
 */
package com.cenarius.dao;

import java.util.List;
import java.util.Set;

import com.cenarius.form.TestHistory;
import com.cenarius.form.User;

/**
 * @author nex6uyu
 *
 */
public interface TestDAO {
	/**
	 * UserToken = Token value with which user has entered in the system.
	 * topic = It can have values like All, Constitution,etc.
	 * testLimit = Wanna to have fixed number of Testlimit.
	 * */
	public List<TestHistory> createTest(User user,String topic,Long testLimit);
	
	/**
	 * Saving the Test created either with marked answer or without marked answer.
	 * */
	public boolean saveTest(List<TestHistory> test);
	
	/**
	 * To know the Test History that how you have performed in the past.
	 * */
	public List<TestHistory> getTestTakenHistory(User user);
	
	/**
	 * To know the Test History that how you have performed in the past.
	 * */
	public Set<List<TestHistory>> getTestTakenHistory(Long userId);
	
	/**
	 * This method will actually save the test from the UI.
	 * */
	public boolean saveActualTest(List<TestHistory> test);
	
}
