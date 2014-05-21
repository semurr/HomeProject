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
	
	public void addPermission(Permission permissionDetail);
	public List<Permission> getAllPermission();

}
