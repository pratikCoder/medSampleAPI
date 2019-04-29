package com.project.med.service;

import java.util.List;

import com.project.med.common.exception.CommonException;
import com.project.med.db.entity.UserRoleEntity;
import com.project.med.model.UserRoleModel;

public interface UserRoleService {

	public UserRoleModel addUserRole(UserRoleModel userRoleModel) throws CommonException;

	public UserRoleModel updateUserRole(UserRoleModel userRoleModel) throws CommonException;

	public void deleteUserRole(Long userRoleId) throws CommonException;

	public UserRoleModel getUserRoleById(Long userRoleId) throws CommonException;

	public List<UserRoleModel> getAllUserRoles() throws CommonException;

	public UserRoleModel getUserRoleByRoleTitle(String roleTitle) throws CommonException;

	public UserRoleEntity getUserRoleEntityById(Long userRoleId) throws CommonException;

	public Boolean userRoleIDIsExist(Long userRoleId) throws CommonException;

	public Boolean userRoleTitleIsExist(String roleTitle) throws CommonException;

	public Long getUserRoleIdByUserRoleObject(UserRoleModel userRoleModel) throws CommonException;

}
