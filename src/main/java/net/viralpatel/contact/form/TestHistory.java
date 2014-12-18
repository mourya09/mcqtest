/**
 * 
 */
package net.viralpatel.contact.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nex6uyu
 * 
 */

@Entity
@Table(name = "test_history")
public class TestHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3643986743193034670L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "USERID", updatable = false, insertable = true)
	private User userToken;

	/* @Column(name="QUESTIONID") */
	@OneToOne(fetch = FetchType.EAGER, targetEntity = MCQ.class)
	@JoinColumn(name = "QUESTIONID", updatable = false, insertable = true)
	private MCQ questionsTaken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TEST_DATE", length = 19, nullable = true, updatable = false, insertable = true)
	private Date testDate;

	@Column(name = "MARKED_ANSWER", nullable = true, updatable = true, insertable = false)
	private Long markedAnswer;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the questionsTaken
	 */
	public MCQ getQuestionsTaken() {
		return questionsTaken;
	}

	/**
	 * @param questionsTaken
	 *            the questionsTaken to set
	 */
	public void setQuestionsTaken(MCQ questionsTaken) {
		this.questionsTaken = questionsTaken;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userToken
	 */
	public User getUserToken() {
		return userToken;
	}

	/**
	 * @param userToken
	 *            the userToken to set
	 */
	public void setUserToken(User userToken) {
		this.userToken = userToken;
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

}
