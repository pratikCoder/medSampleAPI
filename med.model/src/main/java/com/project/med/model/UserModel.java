package com.project.med.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserModel {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long userId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String emailId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long mobileNo;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean isActive;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String rePassword;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private UserRoleModel role;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date createdDate;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date updatedDate;

	public UserModel() {
		super();
	}

	public UserModel(Long userId, String emailId, Long mobileNo, String firstName, String lastName, Boolean isActive,
			String password, String rePassword, UserRoleModel role) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.password = password;
		this.rePassword = rePassword;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public UserRoleModel getRole() {
		return role;
	}

	public void setRole(UserRoleModel role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", firstName="
				+ firstName + ", lastName=" + lastName + ", isActive=" + isActive + ", password=" + password
				+ ", rePassword=" + rePassword + ", role=" + role + "]";
	}

}
