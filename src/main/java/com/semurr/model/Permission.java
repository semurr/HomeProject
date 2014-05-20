package com.semurr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permision table for the user
 * 
 * @author stephen
 * 
 */

@Entity
@Table(name = "permission")
public class Permission {
	
	@Id
	@GeneratedValue
	@Column(name = "permission_id", nullable = false, unique=true)
	private int		permission_id;
		
	@Column(name = "permission_detail")
	private String	permission_detail;

	/**
	 * @return the permission_id
	 */
	public int getPermission_id() {
		return permission_id;
	}

	/**
	 * @param permission_id
	 *            the permission_id to set
	 */
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}	

	/**
	 * @return the permission_detail
	 */
	public String getPermission_detail() {
		return permission_detail;
	}

	/**
	 * @param permission_detail
	 *            the permission_detail to set
	 */
	public void setPermission_detail(String permission_detail) {
		this.permission_detail = permission_detail;
	}

}
