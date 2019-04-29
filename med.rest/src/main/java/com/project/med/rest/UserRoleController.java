package com.project.med.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.med.common.constants.RestCallUrl;
import com.project.med.common.exception.CommonException;
import com.project.med.model.UserRoleModel;
import com.project.med.model.response.Response;
import com.project.med.service.UserRoleService;

@RestController
@RequestMapping(value = RestCallUrl.USER_ROLE_REST_BASE_URL, produces = { "application/JSON" })
public class UserRoleController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRoleService userRoleService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.ADD_USER_ROLE_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> addUserRole(@RequestBody UserRoleModel userRoleModelReq) throws CommonException {

		logger.debug("addUserRole() :: UserRoleModel : " + userRoleModelReq);
		userRoleModelReq.setRoleId(null);
		logger.debug("addUserRole() :: UserRoleModel : " + userRoleModelReq);

		UserRoleModel userRoleModelRes;
		try {
			userRoleModelRes = userRoleService.addUserRole(userRoleModelReq);
			logger.debug("addUserRole() :: UserRoleModel : {}", userRoleModelRes);
		} catch (CommonException e) {
			logger.error("addUserRole() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userRoleModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.UPDATE_USER_ROLE_BY_ID_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> updateUserRole(@RequestBody UserRoleModel userRoleModelReq) throws CommonException {

		logger.debug("updateUserRole() :: UserRoleModel : " + userRoleModelReq);

		UserRoleModel userRoleModelRes;
		try {
			userRoleModelRes = userRoleService.updateUserRole(userRoleModelReq);
			logger.debug("updateUserRole() :: UserRoleModel : {}", userRoleModelRes);
		} catch (CommonException e) {
			logger.error("updateUserRole() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userRoleModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.DELETE_USER_ROLE_BY_ID_URL, method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUserRole(@RequestParam @Valid @Positive @NotNull Long userRoleId)
			throws CommonException {

		logger.debug("deleteUserRole() :: userRoleId : " + userRoleId);

		try {
			userRoleService.deleteUserRole(userRoleId);
			logger.debug("deleteUserRole() :: userRoleId : {}", userRoleId);
		} catch (CommonException e) {
			logger.error("deleteUserRole() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_USER_ROLE_BY_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getUserRoleById(@RequestParam @Valid @Positive @NotNull Long userRoleId)
			throws CommonException {

		logger.debug("getUserRoleById() :: userRoleId : " + userRoleId);

		UserRoleModel userRoleModelRes;
		try {
			userRoleModelRes = userRoleService.getUserRoleById(userRoleId);
			logger.debug("getUserRoleById() :: userRoleModelRes : {}", userRoleModelRes);
		} catch (CommonException e) {
			logger.error("getUserRoleById() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userRoleModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_USER_ROLE_BY_TITLE_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getUserRoleByRoleTitle(@RequestParam @Valid @Positive @NotNull String userRoleTitle)
			throws CommonException {

		logger.debug("getUserRoleByRoleTitle() :: userRoleTitle : " + userRoleTitle);

		UserRoleModel userRoleModelRes;
		try {
			userRoleModelRes = userRoleService.getUserRoleByRoleTitle(userRoleTitle);
			logger.debug("getUserRoleByRoleTitle() :: userRoleModelRes : {}", userRoleModelRes);
		} catch (CommonException e) {
			logger.error("getUserRoleByRoleTitle() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userRoleModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_ALL_USER_ROLES_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getAllUserRoles() throws CommonException {

		logger.debug("getAllUserRoles() :: ");

		List<UserRoleModel> userRoleModelRes;
		try {
			userRoleModelRes = userRoleService.getAllUserRoles();
			logger.debug("getAllUserRoles() :: userRoleModelRes : {}", userRoleModelRes);
		} catch (CommonException e) {
			logger.error("getAllUserRoles() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userRoleModelRes), HttpStatus.OK);
	}

}
