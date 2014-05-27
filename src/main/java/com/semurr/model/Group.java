package com.semurr.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue
	@Column(name = "group_id", unique = true, nullable = false)
	private int			group_id;

	@Column(name = "group_name", nullable = false)
	private String		group_name;

	@ManyToMany(mappedBy = "groups")
	List<UserAccount>	userAccounts;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "group_permission", joinColumns = { @JoinColumn(name = "group_id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id") })
	Set<Permission>	permissions;

	/**
	 * @return the userAccounts
	 */
	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	/**
	 * @param userAccounts
	 *            the userAccounts to set
	 */
	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * @return the group_id
	 */
	public int getGroup_id() {
		return group_id;
	}

	/**
	 * @param group_id
	 *            the group_id to set
	 */
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	/**
	 * @return the group_name
	 */
	public String getGroup_name() {
		return group_name;
	}

	/**
	 * @param group_name
	 *            the group_name to set
	 */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	/**
	 * @return the permissions
	 */
	public Set<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
