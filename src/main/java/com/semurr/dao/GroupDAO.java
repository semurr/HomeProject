package com.semurr.dao;

import java.util.List;

import com.semurr.model.Group;
import com.semurr.model.Permission;

/**
 * @author stephen
 *
 */
public interface GroupDAO {

	/**
	 * @param groupToAdd
	 *            Adds a new group to the table
	 * @return true if created false if not
	 */
	public boolean addGroup(Group groupToAdd);

	/**
	 * @return Returns all groups created
	 */
	public List<Group> getAllGroups();

	/**
	 * @param groupId
	 *            The group_id to search for
	 * @return the group mapped to the id or null if no group found
	 */
	public Group getGroupById(int groupId);

	/**
	 * @param group
	 *            The group you want to add the permission to
	 * @param permission
	 *            the permission you want to add to the group
	 * @return true if they are mapped, false if they are not
	 */
	public boolean addPermissionToGroup(Group group, Permission permission);
}
