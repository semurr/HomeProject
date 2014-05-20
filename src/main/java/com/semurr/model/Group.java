package com.semurr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class Group {

	@Id
	@GeneratedValue
	@Column(name = "group_id", unique = true, nullable = false)
	private int		group_id;

	@Column(name = "group_name", nullable = false)
	private String	group_name;

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

}
