/**
 * 
 */
package com.cenarius.dao;

import java.util.List;

import com.cenarius.form.MCQ;

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
