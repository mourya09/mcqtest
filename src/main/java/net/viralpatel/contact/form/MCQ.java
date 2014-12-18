/**
 * 
 */
package net.viralpatel.contact.form;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nex6uyu
 *
 */

@Entity
@Table(name="MCQ")
public class MCQ {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="QUESTION",nullable = false, length = 500)
	private String question;
	
	@Column(name="OPTION1",nullable = false, length = 500)
	private String option1;

	@Column(name="OPTION2",nullable = false, length = 500)
	private String option2;

	@Column(name="OPTION3",nullable = false, length = 500)
	private String option3;
	
	@Column(name="OPTION4",nullable = false, length = 500)
	private String option4;
	@Column(name="OPTION5",nullable = true, length = 500)
	private String option5;
	
	@Column(name="ANSWER",nullable = false)
	private Long answer;
	
	@Column(name="TOPIC",nullable = false, length = 500)
	private String topic;
	
	@Column(name="MARKED_OPTION")
	private String markedOption;	
	
	@Column(name="created")
	private Date createdDate;

	public Integer getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	public Long getAnswer() {
		return answer;
	}

	public void setAnswer(Long answer) {
		this.answer = answer;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMarkedOption() {
		return markedOption;
	}

	public void setMarkedOption(String markedOption) {
		this.markedOption = markedOption;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
