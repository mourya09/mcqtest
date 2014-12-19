/**
 * 
 */
package com.cenarius.service;

import java.util.List;

import com.cenarius.dao.MCQDAO;
import com.cenarius.form.MCQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nex6uyu
 *
 */
@Service
public class MCQServiceImpl implements MCQService {

	@Autowired
	private MCQDAO mcqDao;
	/* (non-Javadoc)
	 * @see com.cenarius.service.MCQService#addMCQ(com.cenarius.form.MCQ)
	 */
	@Transactional
	public void addMCQ(MCQ mcq) {
		mcqDao.addMCQ(mcq);

	}

	/* (non-Javadoc)
	 * @see com.cenarius.service.MCQService#listMCQs()
	 */
	@Transactional
	public List<MCQ> listMCQs() {
		
		return mcqDao.listMCQs();
	}

	/* (non-Javadoc)
	 * @see com.cenarius.service.MCQService#obtainTest(java.lang.String)
	 */
	@Transactional
	public List<MCQ> obtainTest(String topic) {		
		return mcqDao.obtainTest(topic);
	}
	
	@Transactional
	public void removeMCQ(Integer id)
	{
		mcqDao.removeMCQ(id);
	}

}
