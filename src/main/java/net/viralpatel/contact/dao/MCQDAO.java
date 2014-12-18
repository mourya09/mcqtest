/**
 * 
 */
package net.viralpatel.contact.dao;

import java.util.List;

import net.viralpatel.contact.form.MCQ;

/**
 * @author nex6uyu
 *
 */
public interface MCQDAO {
	public void addMCQ(MCQ mcq);
	public List<MCQ> listMCQs();
	public List<MCQ> obtainTest(String topic);
	public void removeMCQ(Integer id);
}
