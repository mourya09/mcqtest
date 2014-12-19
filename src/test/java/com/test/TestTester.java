/**
 * 
 */
package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cenarius.dao.TestDAO;
import com.cenarius.form.TestHistory;
import com.cenarius.form.User;
import com.google.gson.Gson;

/**
 * @author nex6uyu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestTester {
	
	@Autowired
	private TestDAO testDAO;
	

	@Test
	public void testing()
	{
		
		if(testDAO == null)
		{
			System.out.println("Welcome to Hell");
		}else
		{
			User user = new User();
			user.setUserName("Praveen");
			user.setUserPassword("Kumar");
			user.setId(1L);
			List<TestHistory> list = testDAO.createTest(user, null, 3L);
			if(list != null && list.size() > 0)
			{
				Iterator<TestHistory> iterator = list.iterator();
				TestHistory testHistory = null;
				while(iterator.hasNext())
				{
					testHistory = iterator.next();
					testHistory.setMarkedAnswer(1L);
					testHistory.setUserToken(user);
				}
				boolean result = testDAO.saveTest(list);
				if(result)
				{
					System.out.println("Test saved successfully");
				}else
				{
					System.out.println("Test cannot be saved successfully!!!");
				}
			}
			
		}
	}
	
	@Test
	public void testHistory()
	{
		User user = new User();
		user.setUserName("Praveen");
		user.setUserPassword("Kumar");
		user.setId(1L);
		user.setUserToken("f0b81a8acf4a49a39e6904a5285419ce");
		List<TestHistory> list = testDAO.getTestTakenHistory(user);
		if(list != null && list.size() > 0)
		{
			System.out.println("User has taken the test");
		}else
		{
			System.out.println("User has not taken the test");
		}
	}
	
	@Test
	public void testHistoryByUserId()
	{
		User user = new User();
		user.setUserName("Praveen");
		user.setUserPassword("Kumar");
		user.setId(1L);
		user.setUserToken("f0b81a8acf4a49a39e6904a5285419ce");
		Set<List<TestHistory>> list = testDAO.getTestTakenHistory(user.getId());
		if(list != null && list.size() > 0)
		{
			System.out.println("User has taken the test");
		}else
		{
			System.out.println("User has not taken the test");
		}
	}
	
	
	@Test
	public void transferData()
	{
		com.cenarius.dto.TestDTO[] t = new com.cenarius.dto.TestDTO[2];
		t[0] = new com.cenarius.dto.TestDTO();
		t[1] = new com.cenarius.dto.TestDTO();
		
		t[0].setId(Long.parseLong("2"));
		t[0].setMarkedAnswer(Long.parseLong("4"));
		t[1].setId(Long.parseLong("6"));
		t[1].setMarkedAnswer(Long.parseLong("8"));
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(t,com.cenarius.dto.TestDTO[].class ));
		
	}
	
}
