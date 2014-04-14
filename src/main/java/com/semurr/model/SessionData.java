package com.semurr.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class SessionData implements Serializable{

	private boolean	validated	= false;
	private String	userRole	= "none";

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
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

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
