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
import com.project.med.model.PatientModel;
import com.project.med.model.response.Response;
import com.project.med.service.PatientService;

@RestController
@RequestMapping(value = RestCallUrl.PATIENT_REST_BASE_URL, produces = { "application/JSON" })
public class PatientController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	PatientService patientService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.ADD_PATIENT_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> addPatient(@RequestBody PatientModel patientModelReq) throws CommonException {

		logger.debug("addPatient() :: patientModel : " + patientModelReq);
		patientModelReq.setPatientId(null);
		logger.debug("addPatient() :: patientModel : " + patientModelReq);

		PatientModel patientModelres;
		try {
			patientModelres = patientService.addPatient(patientModelReq);
			logger.debug("addPatient() :: patientModel : {}", patientModelres);
		} catch (CommonException e) {
			logger.error("addPatient() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(patientModelres), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.UPDATE_PATIENT_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> updatePatient(@RequestBody PatientModel patientModelReq) throws CommonException {

		logger.debug("updatePatient() :: patientModel : " + patientModelReq);

		PatientModel patientModelres;
		try {
			patientModelres = patientService.updatePatient(patientModelReq);
			logger.debug("updatePatient() :: patientModel : {}", patientModelres);
		} catch (CommonException e) {
			logger.error("updatePatient() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(patientModelres), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.DELETE_PATIENT_BY_ID_URL, method = RequestMethod.DELETE)
	public ResponseEntity<Response> deletePatient(@RequestParam @Valid @Positive @NotNull Long patientId)
			throws CommonException {
		logger.debug("deletePatient() :: patientId : " + patientId);

		try {
			patientService.deletePatient(patientId);
			logger.debug("deletePatient() :: {}");
		} catch (CommonException e) {
			logger.error("deletePatient() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_PATIENT_BY_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getPatientById(@RequestParam @Valid @Positive @NotNull Long patientId)
			throws CommonException {

		logger.debug("getPatientById() :: patientId : " + patientId);

		PatientModel patientModelres;
		try {
			patientModelres = patientService.getPatientById(patientId);
			logger.debug("getPatientById() :: patientModel : {}", patientModelres);
		} catch (CommonException e) {
			logger.error("getPatientById() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(patientModelres), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_PATIENT_BY_NAME_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getPatientByName(@RequestParam @Valid @Positive @NotNull String first_name)
			throws CommonException {

		logger.debug("getPatientByName() :: first_name : " + first_name);

		PatientModel patientModelres;
		try {
			patientModelres = patientService.getPatientByName(first_name);
			logger.debug("getPatientByName() :: patientModel : {}", patientModelres);
		} catch (CommonException e) {
			logger.error("getPatientByName() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(patientModelres), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_ALL_PATIENT_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getAllPatients() throws CommonException {

		logger.debug("getAllPatients() :: ");

		List<PatientModel> patientModelList;
		try {
			patientModelList = patientService.getAllPatients();
			logger.debug("getAllPatients() :: patientModel : {}", patientModelList);
		} catch (CommonException e) {
			logger.error("getAllPatients() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(patientModelList), HttpStatus.OK);
	}

}
