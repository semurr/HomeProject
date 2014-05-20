package com.semurr.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class SessionData implements Serializable {

	private boolean	validated		= false;
	private int		userAccountId	= 0;

	/**
	 * @return the userAccountId
	 */
	public int getUserAccountId() {
		return userAccountId;
	}

	/**
	 * @param userAccountId
	 *            the userAccountId to set
	 */
	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * @param validated
	 *            the validated to set
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

}
