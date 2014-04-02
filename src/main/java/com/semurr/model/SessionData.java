package com.semurr.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionData {

	private boolean	isValidated = false;
	private String	userRole = "none";
	/**
	 * @return the isValidated
	 */
	public boolean isValidated() {
		return isValidated;
	}
	/**
	 * @param isValidated the isValidated to set
	 */
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
