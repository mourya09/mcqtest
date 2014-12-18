package net.viralpatel.contact.service;

import java.util.List;

import net.viralpatel.contact.form.MCQ;

public interface MCQService {
	public void addMCQ(MCQ mcq);
	public List<MCQ> listMCQs();
	public List<MCQ> obtainTest(String topic);
	public void removeMCQ(Integer id);

}
