package com.project.med.service;

import java.util.List;

import com.project.med.common.exception.CommonException;
import com.project.med.model.UserModel;

public interface UserService {

	public UserModel addUser(UserModel userModel) throws CommonException;

	public UserModel updateUser(UserModel userModel) throws CommonException;

	public void deleteUser(Long userId) throws CommonException;

	public UserModel getUserByUserId(Long userId) throws CommonException;

	public List<UserModel> getAllUsers() throws CommonException;

	public UserModel getUserByUserEmailId(String userEmailId) throws CommonException;

	public Boolean userIsExist(Long userId) throws CommonException;

	// oauth related methods
	public Boolean validateUser(String emailId, String password) throws CommonException;

	public UserAuth getUserAuthorizationByEmailId(String emailId) throws CommonException;

}
