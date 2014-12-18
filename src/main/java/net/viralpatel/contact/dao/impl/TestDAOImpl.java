/**
 * 
 */
package net.viralpatel.contact.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.viralpatel.contact.dao.TestDAO;
import net.viralpatel.contact.form.MCQ;
import net.viralpatel.contact.form.TestHistory;
import net.viralpatel.contact.form.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author nex6uyu
 *
 */

@Repository
public class TestDAOImpl implements TestDAO,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4196155126828319906L;

	@Autowired
	private SessionFactory sessionFactory;
	
	//private Logger logger = Logger.getLogger(TestDAOImpl.class);

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.dao.TestDAO#createTest(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<TestHistory> createTest(User user, String topic, Long testLimit) {
		
		List<TestHistory> list = null;
		if(user == null || user.getId() == null)
		{
			return list;
		}else
		{
			user =(User) sessionFactory.getCurrentSession().get(User.class, user.getId());
			
		}
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MCQ.class);
		
		if(topic != null && !"".equalsIgnoreCase(topic))
		{
			criteria.add(Restrictions.eq("topic", topic));
		}
		
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
			 
		
		/*Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(
						"from MCQ ").addEntity(MCQ.class);	*/
		if(testLimit != null && testLimit > 0)
		{
			criteria.setMaxResults(testLimit.intValue());
			//query.setMaxResults( testLimit.intValue());
		}
		List<MCQ> mcqList = criteria.list();;
		if(mcqList != null && mcqList.size() > 0)
		{
			list = new ArrayList<TestHistory>(mcqList.size());
			Iterator<MCQ> iterator = mcqList.iterator();
			MCQ mcq = null;
			TestHistory testHistory = null;
			while(iterator.hasNext())
			{ 
				mcq = iterator.next();
				testHistory= new TestHistory();
				testHistory.setUserToken(user);
				testHistory.setQuestionsTaken(mcq);
				list.add(testHistory);
				
			}
		}
		
		
		return list;
	}
	
	public boolean saveActualTest(List<TestHistory> test)
	{
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			Iterator<TestHistory> iterator = test.iterator();
			Integer count = 0;
			int modVal =20;
						
			TestHistory testHistory = null, sessionTestHistory = null;
			
			while(iterator.hasNext())
			{
				testHistory = iterator.next();
				/*sessionTestHistory =(TestHistory) session.get(TestHistory.class,testHistory.getId());
				sessionTestHistory.setMarkedAnswer(testHistory.getMarkedAnswer());*/
				session.update(testHistory);
				count++;
				if(test.size() < modVal && count % modVal == 0)
				{
					session.flush();
			        session.clear();
				}
				
			}
			
			result = true;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			tx.commit();
			session.close();
			//logger.info("saveTest() end");
		}
		return result;
		
	}

	@Override
	public boolean saveTest(List<TestHistory> test) {
		//logger.info("saveTest() started");
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			Iterator<TestHistory> iterator = test.iterator();
			Integer count = 0;
			int modVal =20;
			Date date = new Date();
			
			TestHistory testHistory = null;
			while(iterator.hasNext())
			{
				testHistory = iterator.next();
				testHistory.setTestDate(date);
				session.save(testHistory);
				count++;
				if(test.size() < modVal && count % modVal == 0)
				{
					session.flush();
			        session.clear();
				}
				
			}
			
			result = true;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			tx.commit();
			session.close();
			//logger.info("saveTest() end");
		}
		return result;
	}
	
	@Override
	public List<TestHistory> getTestTakenHistory(User user)
	{
		//logger.info("getTestTakenHistory start");
		List<TestHistory> list = null;
		try{
			
		Criteria criteria =  sessionFactory
				.getCurrentSession().createCriteria(TestHistory.class).addOrder(Order.desc("testDate"));
		criteria.add(Restrictions.eq("userToken", user));
		list = criteria.list();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//logger.error("Error in the method " + ex.getMessage());
		}finally
		{
			//logger.info("getTestTakenHistory end");
		}
		return list;
	}
	
	@SuppressWarnings("unused")
	public Set<List<TestHistory>> getTestTakenHistory(final Long userId)
	{
		//logger.info("getTestTakenHistory("+userId+") started");
		Set<List<TestHistory>> result = new HashSet<List<TestHistory>>();
		try
		{
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(TestHistory.class).addOrder(Order.desc("testDate"));
			criteria.add(Restrictions.eq("userToken.id",userId));
			List<TestHistory> rangeList = criteria.list();
			if(rangeList != null && rangeList.size() > 0)
			{
				Date date = rangeList.get(0).getTestDate();
				List<TestHistory> resultHistoryList= new ArrayList<TestHistory>();
				resultHistoryList.add(rangeList.get(0));
				TestHistory temp = null;
				
				for(int i=1;rangeList.size() > 1 && i< rangeList.size();i++)
				{
					temp = rangeList.get(i);
					if(temp.getTestDate().equals(date))
					{
						resultHistoryList.add(temp);
						if(i == ( rangeList.size() - 1))
						{
							result.add(resultHistoryList);
						}
					}else
					{
						result.add(resultHistoryList);
						date = temp.getTestDate();
						resultHistoryList = new ArrayList<TestHistory>();						
					}
					
				}
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			//logger.info("getTestTakenHistory("+userId+") end");
		}
		
		return result;
		
	}

}
