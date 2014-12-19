/**
 * 
 */
package com.cenarius.service;

import java.util.List;
import java.util.Set;

import com.cenarius.dto.TestDTO;
import com.cenarius.form.TestHistory;
import com.cenarius.form.User;

/**
 * @author Praveen Kumar
 *
 */
public interface TestService {

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
	
	public boolean saveActualTest(TestDTO[] testDTO);
}
