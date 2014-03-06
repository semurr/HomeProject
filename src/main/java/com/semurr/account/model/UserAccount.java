package com.semurr.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserAccount implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	Integer	user_id;

	@Column(name = "email", unique = true, nullable = false)
	String	email;

	@Column(name = "password", nullable = false)
	byte[]	password;

	@Column(name = "salt", nullable = false)
	byte[]	salt;

	/**
	 * @return the user_id
	 */
	public Integer getUser_id() {
		System.out.println("1");
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		System.out.println("1a");
		this.user_id = user_id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public byte[] getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}

	/**
	 * @return the salt
	 */
	public byte[] getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 *            the salt to set
	 */
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
}
