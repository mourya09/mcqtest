package com.cenarius.service;

import java.util.List;

import com.cenarius.form.MCQ;

public interface MCQService {
	public void addMCQ(MCQ mcq);
	public List<MCQ> listMCQs();
	public List<MCQ> obtainTest(String topic);
	public void removeMCQ(Integer id);

}
