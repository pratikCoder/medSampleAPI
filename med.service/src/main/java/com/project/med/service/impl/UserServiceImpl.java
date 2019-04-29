package com.project.med.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;
import com.project.med.db.entity.UserEntity;
import com.project.med.db.repository.UserJpaRepository;
import com.project.med.model.UserModel;
import com.project.med.model.UserRoleModel;
import com.project.med.service.UserAuth;
import com.project.med.service.UserRoleService;
import com.project.med.service.UserService;
import com.project.med.service.utils.CommonUtils;
import com.project.med.service.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserJpaRepository userJpaRepo;

	@Autowired
	private UserAuth userAuth;

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	private ModelMapper modelMapper;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserModel addUser(UserModel userModel) throws CommonException {
		logger.debug("addUser() :: userModel : " + userModel);

		UserUtils.emailValidate(userModel.getEmailId());
		UserUtils.passwordValidate(userModel.getPassword(), userModel.getRePassword());
		UserUtils.mobileValidate(userModel.getMobileNo());
		UserUtils.userNameValidate(userModel.getFirstName(), userModel.getLastName());
		UserUtils.roleValidate(userModel.getRole());
		// CommonUtils.IdsValidate(userModel.getRole().getRoleId());
		// userRoleService.userRoleIDIsExist(userModel.getRole().getRoleId());

		UserRoleModel userRole = new UserRoleModel();
		userRole = userModel.getRole();

		Long userRoleId = userRoleService.getUserRoleIdByUserRoleObject(userRole);

		// Long userAdminRoleId = userAuth.getUser().getRoleId();
		//
		// if (userAdminRoleId == 1) {
		Date createdDate = CommonUtils.currentDate();

		UserEntity userEntity = new UserEntity();
		userEntity.setCreatedDate(createdDate);
		userEntity.setUpdatedDate(createdDate);
		modelMapper.map(userModel, userEntity);

		String password = userEntity.getPassword();

		String encryptPassword = passwordEncoder.encode(password);

		userEntity.setPassword(encryptPassword);
		userEntity.setRoleId(userRoleId);

		userEntity = userJpaRepo.saveAndFlush(userEntity);
		modelMapper.map(userEntity, userModel);

		userRole = userRoleService.getUserRoleById(userRoleId);

		userModel.setRole(userRole);
		userModel.setRePassword(null);
		userModel.setPassword(null);
		// } else {
		// throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		// }
		logger.debug("addUser() :: userModel " + userModel);
		return userModel;
	}

	@Override
	public UserModel updateUser(UserModel userModel) throws CommonException {
		logger.debug("updateUser() :: userModel : " + userModel);

		CommonUtils.IdsValidate(userModel.getUserId());
		userIsExist(userModel.getUserId());
		//
		// String emailId = userModel.getEmailId();
		// Long mobileNo = userModel.getMobileNo();
		// String firstName = userModel.getFirstName();
		// String lastName = userModel.getLastName();
		// Boolean isActive = userModel.getIsActive();
		// String password = userModel.getPassword();
		// UserRoleModel role = userModel.getRole();
		// boolean isExist =
		// userRoleService.userRoleIDIsExist(userModel.getRole().getRoleId());
		//
		// Long userRoleId = role.getRoleId();
		// String userRoleTitle = role.getRoleTitle();
		// String userRoleDesc = role.getRoleDesc();
		//
		// UserEntity userEntityFromDB =
		// getUserEntityByUserId(userModel.getUserId());
		// UserRoleModel userRoleModelFromDB =
		// userRoleService.getUserRoleById(userEntityFromDB.getRoleId());
		//
		// if (emailId.equals(null)) {
		// emailId = userEntityFromDB.getEmailId();
		// }
		// if (mobileNo.equals(null)) {
		// mobileNo = userEntityFromDB.getEmailId();
		// }
		// if (firstName.equals(null)) {
		// firstName = userEntityFromDB.getEmailId();
		// }
		// if (lastName.equals(null)) {
		// lastName = userEntityFromDB.getEmailId();
		// }
		// if (isActive.equals(null)) {
		// isActive = userEntityFromDB.getEmailId();
		// }
		// if (password.equals(null)) {
		// password = userEntityFromDB.getEmailId();
		// }
		// if (userRoleId.equals(null)) {
		// userRoleId = userRoleModelFromDB.getRoleId();
		// }
		// if (userRoleTitle.equals(null)) {
		// userRoleTitle = userRoleModelFromDB.getRoleTitle();
		// }
		// if (userRoleDesc.equals(null)) {
		// userRoleDesc = userRoleModelFromDB.getRoleDesc();
		// }

		Long userAdminRoleId = userAuth.getUser().getRoleId();

		if (userAdminRoleId == 1) {
			Date updatedDate = CommonUtils.currentDate();

			UserEntity userEntity = new UserEntity();

			UserEntity userEntityFromDB = getUserEntityByUserId(userModel.getUserId());

			modelMapper.map(userModel, userEntity);

			userEntity.setUpdatedDate(updatedDate);

			userEntity.setCreatedDate(userEntityFromDB.getCreatedDate());
			userEntity.setRoleId(userEntityFromDB.getRoleId());
			userEntity.setIsActive(userEntityFromDB.getIsActive());
			userEntity.setPassword(userEntityFromDB.getPassword());

			userEntity = userJpaRepo.saveAndFlush(userEntity);
			modelMapper.map(userEntity, userModel);

			userModel.setRePassword(null);
			userModel.setPassword(null);
		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("updateUser() :: userModel " + userModel);
		return userModel;
	}

	@Override
	public void deleteUser(Long userId) throws CommonException {
		logger.debug("deleteUser() :: userId : " + userId);

		CommonUtils.IdsValidate(userId);
		userIsExist(userId);

		Long userAdminRoleId = userAuth.getUser().getRoleId();

		if (userAdminRoleId == 1) {
			userJpaRepo.deleteById(userId);
		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("deleteUser() :: ");
		return;

	}

	@Override
	public UserModel getUserByUserId(Long userId) throws CommonException {
		logger.debug("getUserByUserId() :: userId : " + userId);

		CommonUtils.IdsValidate(userId);
		userIsExist(userId);

		Long userAdminRoleId = userAuth.getUser().getRoleId();
		UserModel userModel = new UserModel();
		if (userAdminRoleId == 1) {
			UserEntity userEntity = new UserEntity();
			userEntity = userJpaRepo.getOne(userId);

			modelMapper.map(userEntity, userModel);

			userModel.setRePassword(null);
			userModel.setPassword(null);

		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("updateUser() :: userModel " + userModel);
		return userModel;

	}

	@Override
	public List<UserModel> getAllUsers() throws CommonException {
		logger.debug("getAllUsers() :: ");

		List<UserEntity> userEntityList = new ArrayList<UserEntity>();
		List<UserModel> userModelList = new ArrayList<UserModel>();

		userEntityList = userJpaRepo.findAll();

		for (int i = 0; i < userEntityList.size(); i++) {
			UserModel userModel = new UserModel();

			UserEntity userEntity = userEntityList.get(i);
			modelMapper.map(userEntity, userModel);

			userModelList.add(userModel);
		}

		logger.debug("getAllUsers() :: userModelList : " + userModelList);
		return userModelList;
	}

	@Override
	public UserModel getUserByUserEmailId(String userEmailId) throws CommonException {
		logger.debug("getUserByUserEmailId() :: userEmailId : " + userEmailId);

		UserUtils.emailValidate(userEmailId);

		UserModel userModel = new UserModel();
		UserEntity userEntity = new UserEntity();
		userEntity = userJpaRepo.getUserByEmailId(userEmailId);

		modelMapper.map(userEntity, userModel);
		userModel.setRePassword(null);
		userModel.setPassword(null);
		logger.debug("getUserByUserEmailId() :: userModel " + userModel);
		return userModel;
	}

	@Override
	public Boolean userIsExist(Long userId) throws CommonException {
		logger.debug("userIsExist() :: userId : " + userId);
		Boolean isExist = false;

		isExist = userJpaRepo.existsById(userId);
		if (isExist == false) {
			logger.error("userIsExist() :: userId : errorMessages : {} ", ErrorMessages.UNAVAILABLE_USER_ID);

			throw new CommonException(ErrorMessages.UNAVAILABLE_USER_ID);
		}
		return isExist;
	}

	private UserEntity getUserEntityByUserId(Long userId) throws CommonException {
		logger.debug("getUserEntityByUserId() :: userId : " + userId);

		CommonUtils.IdsValidate(userId);
		userIsExist(userId);

		UserEntity userEntity = userJpaRepo.getOne(userId);
		logger.debug("getUserEntityByUserId() :: userEntity : " + userEntity);

		return userEntity;
	}

	// below isOAuth 2 related functionalities

	@Override
	public Boolean validateUser(String emailId, String password) throws CommonException {
		Boolean isValidUser = false;
		UserEntity userEntity = null;
		if (emailId.contains("@")) {
			userEntity = userJpaRepo.getUserByEmailId(emailId);
		}
		if (userEntity == null) {
			logger.error(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
			throw new CommonException(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
		} else if (!passwordEncoder.matches(password, userEntity.getPassword())) {
			logger.error(password, ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
			throw new CommonException(ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
		} else {
			isValidUser = true;
		}

		return isValidUser;
	}

	@Override
	public UserAuth getUserAuthorizationByEmailId(String emailId) throws CommonException {

		// UserAuth userAuth = new UserAuthImpl();

		logger.debug("getUserAuthorizationByEmailId() :: emailId : " + emailId);
		UserEntity userEntity = validateIdAndGetUserEnt(emailId);
		userAuth.setUser(userEntity);

		// Long userId = userEntity.getUserId();
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("USER");
		authoritiesList.add(sga);
		userAuth.setAuthoritiesList(authoritiesList);
		logger.debug("getUserAuthorizationByEmailId() :: userAuth : " + userAuth.toString());
		return userAuth;
	}

	private UserEntity validateIdAndGetUserEnt(String emailId) throws CommonException {
		if (!emailId.contains("@")) {
			throw new CommonException(ErrorMessages.USER_EMAIL_INVALID);
		}

		UserEntity userEntity = userJpaRepo.getUserByEmailId(emailId);

		if (userEntity == null) {
			logger.error(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
			throw new CommonException(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
		}
		return userEntity;
	}

}
