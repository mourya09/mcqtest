/**
 * 
 */
package com.cenarius.dao;

import java.util.List;

import com.cenarius.form.MCQ;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Praveen Kumar
 *
 */
@Repository
public class MCQDAOImpl implements MCQDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.cenarius.dao.MCQDAO#addMCQ(com.cenarius.form.MCQ)
	 */
	
	public void addMCQ(MCQ mcq) {
		Session session=null;
	    try 
	    {
	     session = sessionFactory.openSession();
	    session.save(mcq);
	    }
	    catch(Exception e)
	    {
	     //Logging
	    }
	    finally
	    {
	        if(session !=null && session.isOpen())
	        {
	          session.close();
	          session=null;
	        }
	    }
		
		
		

	}

	/* (non-Javadoc)
	 * @see com.cenarius.dao.MCQDAO#listMCQs()
	 */
	
	public List<MCQ> listMCQs() {		
		List<MCQ> list = null;
		
		 list =  sessionFactory.getCurrentSession().createQuery("from MCQ order by id desc").setMaxResults(10)
					.list();	    
	     
	     return list;  
		
	    
	}

	/* (non-Javadoc)
	 * @see com.cenarius.dao.MCQDAO#obtainTest(java.lang.String)
	 */
	
	public List<MCQ> obtainTest(String topic) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MCQ.class);
		criteria.add(Restrictions.eq("topic", topic));
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(10);
		return criteria.list();			
	}
	
	public void removeMCQ(Integer id)
	{
		MCQ mcq = (MCQ) sessionFactory.getCurrentSession().load(
				MCQ.class, id);
		if (null != mcq) {
			sessionFactory.getCurrentSession().delete(mcq);
		}
	}

}
