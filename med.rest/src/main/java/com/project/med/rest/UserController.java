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
import com.project.med.model.UserModel;
import com.project.med.model.response.Response;
import com.project.med.service.UserService;

@RestController
@RequestMapping(value = RestCallUrl.USER_REST_BASE_URL, produces = { "application/JSON" })
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.ADD_USER_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> addUser(@RequestBody UserModel userModelReq) throws CommonException {

		logger.debug("addUser() :: userModel : " + userModelReq);
		userModelReq.setUserId(null);
		userModelReq.setIsActive(true);
		logger.debug("addUser() :: userModel : " + userModelReq);

		UserModel userModelRes;
		try {
			userModelRes = userService.addUser(userModelReq);
			logger.debug("addUser() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("addUser() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.UPDATE_USER_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> updateUser(@RequestBody UserModel userModelReq) throws CommonException {

		logger.debug("updateUser() :: userModel : " + userModelReq);
		userModelReq.setPassword(null);
		userModelReq.setRePassword(null);
		logger.debug("updateUser() :: userModel : " + userModelReq);

		UserModel userModelRes;
		try {
			userModelRes = userService.updateUser(userModelReq);
			logger.debug("updateUser() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("updateUser() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.DELETE_USER_BY_ID_URL, method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUser(@RequestParam @Valid @Positive @NotNull Long userId)
			throws CommonException {

		logger.debug("deleteUser() :: userId : " + userId);
		try {
			userService.deleteUser(userId);
			logger.debug("deleteUser() :: {}");
		} catch (CommonException e) {
			logger.error("deleteUser() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_USER_BY_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getUserByUserId(@RequestParam @Valid @Positive @NotNull Long userId)
			throws CommonException {

		logger.debug("getUserByUserId() :: userId : " + userId);

		UserModel userModelRes;
		try {
			userModelRes = userService.getUserByUserId(userId);
			logger.debug("getUserByUserId() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("getUserByUserId() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_ALL_USERS_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getAllUsers() throws CommonException {

		logger.debug("getAllUsers() :: ");

		List<UserModel> userModelListRes;
		try {
			userModelListRes = userService.getAllUsers();
			logger.debug("getAllUsers() :: userModelList : {}", userModelListRes);
		} catch (CommonException e) {
			logger.error("getAllUsers() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userModelListRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_USER_BY_EMAIL_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getUserByUserEmailId(@RequestParam @Valid @Positive @NotNull String userEmailId)
			throws CommonException {

		logger.debug("getUserByUserEmailId() :: userEmailId : " + userEmailId);

		UserModel userModelRes;
		try {
			userModelRes = userService.getUserByUserEmailId(userEmailId);
			logger.debug("getUserByUserEmailId() :: userModel: {}", userModelRes);
		} catch (CommonException e) {
			logger.error("getUserByUserEmailId() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(userModelRes), HttpStatus.OK);
	}

}
