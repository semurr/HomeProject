package com.semurr.dao;

import java.util.List;

import com.semurr.model.Permission;

/**
 * DAO for user permission
 * 
 * 
 * @author stephen
 * 
 */
public interface PermissionDAO {

	/**
	 * @param permissionDetail
	 *            The new permission you want to add
	 * @return true if the permission is added, false if not.
	 */
	public boolean addPermission(Permission permissionDetail);

	/**
	 * @return all permission in the permission table
	 */
	public List<Permission> getAllPermission();

	/**
	 * @param permissionId
	 *            The id of the permission you want to grab
	 * @return the permssion for the id or null if not found
	 */
	public Permission getPermissionById(int permissionId);

}
