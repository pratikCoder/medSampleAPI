package com.project.med.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;
import com.project.med.db.entity.UserRoleEntity;
import com.project.med.db.repository.UserRoleJpaRepository;
import com.project.med.model.UserRoleModel;
import com.project.med.service.UserAuth;
import com.project.med.service.UserRoleService;
import com.project.med.service.utils.CommonUtils;
import com.project.med.service.utils.UserRoleUtils;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRoleJpaRepository userRoleJpaRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserAuth userAuth;

	@Override
	public UserRoleModel addUserRole(UserRoleModel userRoleModel) throws CommonException {
		logger.debug("addUserRole() :: userRoleModel : " + userRoleModel);

		UserRoleUtils.roleTitleValidate(userRoleModel.getRoleTitle());

		Long userAdminRoleId = userAuth.getUser().getRoleId();

		if (userAdminRoleId == 1) {
			UserRoleEntity userRoleEntity = new UserRoleEntity();
			modelMapper.map(userRoleModel, userRoleEntity);

			userRoleEntity = userRoleJpaRepo.saveAndFlush(userRoleEntity);
			modelMapper.map(userRoleEntity, userRoleModel);
		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("addUserRole() :: userRoleModel : " + userRoleModel);

		return userRoleModel;
	}

	@Override
	public UserRoleModel updateUserRole(UserRoleModel userRoleModel) throws CommonException {
		logger.debug("updateUserRole() :: userRoleModel : " + userRoleModel);

		userRoleIDIsExist(userRoleModel.getRoleId());
		UserRoleUtils.roleTitleValidate(userRoleModel.getRoleTitle());
		CommonUtils.IdsValidate(userRoleModel.getRoleId());

		Long userAdminRoleId = userAuth.getUser().getRoleId();

		if (userAdminRoleId == 1) {

			UserRoleEntity userRoleEntity = new UserRoleEntity();
			modelMapper.map(userRoleModel, userRoleEntity);

			userRoleEntity = userRoleJpaRepo.saveAndFlush(userRoleEntity);
			modelMapper.map(userRoleEntity, userRoleModel);
		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("updateUserRole() :: userRoleModel : " + userRoleModel);

		return userRoleModel;
	}

	@Override
	public void deleteUserRole(Long userRoleId) throws CommonException {
		logger.debug("deleteUserRole() :: userRoleId : " + userRoleId);

		CommonUtils.IdsValidate(userRoleId);
		userRoleIDIsExist(userRoleId);

		Long userAdminRoleId = userAuth.getUser().getRoleId();

		if (userAdminRoleId == 1) {
			userRoleJpaRepo.deleteById(userRoleId);

		} else {
			throw new CommonException(ErrorMessages.USER_IS_NOT_ADMIN);
		}
		logger.debug("deleteUserRole()");
		return;
	}

	@Override
	public UserRoleModel getUserRoleById(Long userRoleId) throws CommonException {
		logger.debug("getUserRoleById() :: userRoleId : " + userRoleId);

		CommonUtils.IdsValidate(userRoleId);
		userRoleIDIsExist(userRoleId);

		UserRoleEntity userRoleEntity = new UserRoleEntity();
		UserRoleModel userRoleModel = new UserRoleModel();

		userRoleEntity = userRoleJpaRepo.getOne(userRoleId);

		modelMapper.map(userRoleEntity, userRoleModel);

		logger.debug("getUserRoleById() :: userRoleModel : " + userRoleModel);
		return userRoleModel;
	}

	@Override
	public UserRoleModel getUserRoleByRoleTitle(String roleTitle) throws CommonException {
		logger.debug("getUserRoleByRoleTitle() :: roleTitle : " + roleTitle);

		userRoleTitleIsExist(roleTitle);
		UserRoleUtils.roleTitleValidate(roleTitle);

		UserRoleEntity userRoleEntity = new UserRoleEntity();
		UserRoleModel userRoleModel = new UserRoleModel();

		userRoleEntity = userRoleJpaRepo.getUserByRoleTitle(roleTitle);

		modelMapper.map(userRoleEntity, userRoleModel);

		logger.debug("getUserRoleByRoleTitle() :: userRoleModel : " + userRoleModel);
		return userRoleModel;
	}

	@Override
	public List<UserRoleModel> getAllUserRoles() throws CommonException {
		logger.debug("getAllUserRoles() :: ");

		List<UserRoleEntity> userRoleEntityList = new ArrayList<UserRoleEntity>();
		List<UserRoleModel> userRoleModelList = new ArrayList<UserRoleModel>();

		userRoleEntityList = userRoleJpaRepo.findAll();

		for (int i = 0; i < userRoleEntityList.size(); i++) {
			UserRoleModel userRoleModel = new UserRoleModel();

			UserRoleEntity userRoleEntity = userRoleEntityList.get(i);
			modelMapper.map(userRoleEntity, userRoleModel);

			userRoleModelList.add(userRoleModel);
		}

		logger.debug("getAllUserRoles() :: userRoleModelList : " + userRoleModelList);
		return userRoleModelList;
	}

	@Override
	public UserRoleEntity getUserRoleEntityById(Long userRoleId) throws CommonException {
		logger.debug("getUserRoleEntityById() :: userRoleId : " + userRoleId);

		CommonUtils.IdsValidate(userRoleId);
		userRoleIDIsExist(userRoleId);

		UserRoleEntity userRoleEntity = new UserRoleEntity();

		userRoleEntity = userRoleJpaRepo.getOne(userRoleId);

		logger.debug("getUserRoleEntityById() :: userRoleEntity : " + userRoleEntity);
		return userRoleEntity;
	}

	@Override
	public Boolean userRoleIDIsExist(Long userRoleId) throws CommonException {
		logger.debug("userRoleIDIsExist() :: userRoleId : " + userRoleId);

		CommonUtils.IdsValidate(userRoleId);
		Boolean isExist = false;

		isExist = userRoleJpaRepo.existsById(userRoleId);
		if (isExist == false) {
			logger.error("userRoleIDIsExist() :: userRoleId : errorMessages : {} ",
					ErrorMessages.UNAVAILABLE_USER_ROLE_ID);

			throw new CommonException(ErrorMessages.UNAVAILABLE_USER_ROLE_ID);
		}
		return isExist;
	}

	@Override
	public Boolean userRoleTitleIsExist(String roleTitle) throws CommonException {
		logger.debug("userRoleIDIsExist() :: roleTitle : " + roleTitle);

		UserRoleUtils.roleTitleValidate(roleTitle);
		Boolean isExist = false;

		isExist = userRoleJpaRepo.existsByRoleTitle(roleTitle);
		if (isExist == false) {
			logger.error("userRoleIDIsExist() :: roleTitle : errorMessages : {} ",
					ErrorMessages.UNAVAILABLE_USER_ROLE_TITLE);

			throw new CommonException(ErrorMessages.UNAVAILABLE_USER_ROLE_TITLE);
		}
		return isExist;
	}

	@Override
	public Long getUserRoleIdByUserRoleObject(UserRoleModel userRoleModel) throws CommonException {

		logger.debug("getUserRoleIdByUserRoleObject() :: userRoleModel : " + userRoleModel);
		Long userRoleId = null;
		Boolean isExist = userRoleTitleIsExist(userRoleModel.getRoleTitle());
		if (isExist) {
			UserRoleEntity userRoleEntity = new UserRoleEntity();
			userRoleEntity = userRoleJpaRepo.getUserByRoleTitle(userRoleModel.getRoleTitle());
			// if (userRoleModel.getRoleDesc().equals(null)) {
			// userRoleId = userRoleEntity.getRoleId();
			// }else
			// if(userRoleModel.getRoleDesc().equals(userRoleEntity.getRoleDesc()))
			// {
			userRoleId = userRoleEntity.getRoleId();
			// }
		} else {
			userRoleModel = addUserRole(userRoleModel);
			userRoleId = userRoleModel.getRoleId();
		}
		CommonUtils.IdsValidate(userRoleId);
		return userRoleId;
	}
}
