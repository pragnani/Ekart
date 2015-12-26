package com.ekart.app.model;

import java.util.List;

public interface IRole {
	String getName();

	void setName(String name);

	Long getRoleId();

	void setRoleId(Long roleId);

	List<User> getUsers();

	void setUsers(List<User> users);

	public String getDisplayName();

	public void setDisplayName(String displayName);

}
