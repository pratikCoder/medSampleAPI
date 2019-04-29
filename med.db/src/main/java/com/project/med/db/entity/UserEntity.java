package com.project.med.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "email_id", unique = true)
	private String emailId;
	@Column(name = "mobile_no")
	private Long mobileNo;

	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "isActive")
	private Boolean isActive;
	@Column(name = "password")
	private String password;

	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "role_id")
	private Long roleId;

	public UserEntity() {
		super();
	}

	public UserEntity(Long userId, String emailId, Long mobileNo, String firstName, String lastName, Boolean isActive,
			String password, Date createdDate, Date updatedDate, Long roleId) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.roleId = roleId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", firstName="
				+ firstName + ", lastName=" + lastName + ", isActive=" + isActive + ", password=" + password
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", roleId=" + roleId + "]";
	}

}
