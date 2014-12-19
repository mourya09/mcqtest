/**
 * 
 */
package com.cenarius.dto;

import java.io.Serializable;
import java.util.Date;

import com.cenarius.form.MCQ;
import com.cenarius.form.User;

/**
 * @author Praveen Kumar
 * 
 */
public class TestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2587881560532460893L;

	private Long id;

	private User user;

	private MCQ mcq;

	private Date testDate;

	private Long markedAnswer;

	private String topic;

	private Long testLimit;
	
	private TestDTO[] testDTO;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 *            the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the testLimit
	 */
	public Long getTestLimit() {
		return testLimit;
	}

	/**
	 * @param testLimit
	 *            the testLimit to set
	 */
	public void setTestLimit(Long testLimit) {
		this.testLimit = testLimit;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the mcq
	 */
	public MCQ getMcq() {
		return mcq;
	}

	/**
	 * @param mcq
	 *            the mcq to set
	 */
	public void setMcq(MCQ mcq) {
		this.mcq = mcq;
	}

	/**
	 * @return the testDate
	 */
	public Date getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate
	 *            the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return the markedAnswer
	 */
	public Long getMarkedAnswer() {
		return markedAnswer;
	}

	/**
	 * @param markedAnswer
	 *            the markedAnswer to set
	 */
	public void setMarkedAnswer(Long markedAnswer) {
		this.markedAnswer = markedAnswer;
	}

	/**
	 * @return the testDTO
	 */
	public TestDTO[] getTestDTO() {
		return testDTO;
	}

	/**
	 * @param testDTO the testDTO to set
	 */
	public void setTestDTO(TestDTO[] testDTO) {
		this.testDTO = testDTO;
	}

}
