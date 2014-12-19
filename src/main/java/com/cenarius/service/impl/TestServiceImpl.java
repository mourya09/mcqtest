/**
 * 
 */
package com.cenarius.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cenarius.dao.TestDAO;
import com.cenarius.dto.TestDTO;
import com.cenarius.form.TestHistory;
import com.cenarius.form.User;
import com.cenarius.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nex6uyu
 *
 */
@Service
public class TestServiceImpl implements TestService {

	//private Logger logger = Logger.getLogger(TestServiceImpl.class);
	@Autowired
	private TestDAO testDAO;
	/* (non-Javadoc)
	 * @see com.cenarius.service.TestService#createTest(com.cenarius.form.User, java.lang.String, java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<TestHistory> createTest(User user, String topic, Long testLimit) {
		//logger.info("createTest() Started ");
		List<TestHistory> list =  testDAO.createTest(user, topic, testLimit);
		
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
				//logger.info("Test saved successfully");
			}else
			{
			//	logger.info("Test cannot be saved successfully!!!");
			}
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.cenarius.service.TestService#saveTest(java.util.List)
	 */
	@Transactional(readOnly = false,isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean saveTest(List<TestHistory> test) {
		//logger.info("saveTest() Started ");
		return testDAO.saveTest(test);
	}

	/* (non-Javadoc)
	 * @see com.cenarius.service.TestService#getTestTakenHistory(com.cenarius.form.User)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<TestHistory> getTestTakenHistory(User user) {
		//logger.info("getTestTakenHistory(User user) Started ");
		return testDAO.getTestTakenHistory(user);
	}

	/* (non-Javadoc)
	 * @see com.cenarius.service.TestService#getTestTakenHistory(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<List<TestHistory>> getTestTakenHistory(Long userId) {
		//logger.info("getTestTakenHistory(Long userId) Started ");
		Set<List<TestHistory>> set =  testDAO.getTestTakenHistory(userId);
		//logger.info("getTestTakenHistory(Long userId) end ");
		return set;
	}
	
	@Override
	public boolean saveActualTest(TestDTO[] testDTO)
	{
		boolean result = false;
		if(testDTO == null || testDTO.length == 0)
		{
			System.out.println("TestDTO is null. Request to submit it properly");
			return result;
		}
		
		
		List<TestHistory> list = new ArrayList<TestHistory>(testDTO.length);
		TestHistory th = null;
		for(TestDTO t:testDTO)
		{
			th = new TestHistory();
			th.setId(t.getId());
			th.setMarkedAnswer(t.getMarkedAnswer());
			list.add(th);
		}
		result = testDAO.saveActualTest(list);
		
		return result;
	}

}
