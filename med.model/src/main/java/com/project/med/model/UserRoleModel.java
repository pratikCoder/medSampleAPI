package com.project.med.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserRoleModel {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long roleId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String roleTitle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String roleDesc;

	public UserRoleModel() {
		super();
	}

	public UserRoleModel(Long roleId, String roleTitle, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleTitle = roleTitle;
		this.roleDesc = roleDesc;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleModel [roleId=" + roleId + ", roleTitle=" + roleTitle + ", roleDesc=" + roleDesc + "]";
	}
}
