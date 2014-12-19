/**
 * 
 */
package com.cenarius.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Praveen Kumar
 *
 */

@Entity
@Table(name="USER")
@Component
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3117076186288970899L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	
	@Column(name="USERNAME",nullable = false, length = 30)
	private String userName;
	
	@Column(name="USERPASSWORD",nullable = false, length = 30)
	private String userPassword;
	
	@Column(name="USERTOKEN",nullable = false, length = 32)
	private String userToken;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userToken
	 */
	public String getUserToken() {
		return userToken;
	}

	/**
	 * @param userToken the userToken to set
	 */
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	
	

}
