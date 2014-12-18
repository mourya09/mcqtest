/**
 * 
 */
package net.viralpatel.contact.service;

import java.util.List;

import net.viralpatel.contact.dao.MCQDAO;
import net.viralpatel.contact.form.MCQ;

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
	 * @see net.viralpatel.contact.service.MCQService#addMCQ(net.viralpatel.contact.form.MCQ)
	 */
	@Transactional
	public void addMCQ(MCQ mcq) {
		mcqDao.addMCQ(mcq);

	}

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.service.MCQService#listMCQs()
	 */
	@Transactional
	public List<MCQ> listMCQs() {
		
		return mcqDao.listMCQs();
	}

	/* (non-Javadoc)
	 * @see net.viralpatel.contact.service.MCQService#obtainTest(java.lang.String)
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
