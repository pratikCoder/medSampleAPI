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
import com.project.med.model.MedicalTestModel;
import com.project.med.model.response.Response;
import com.project.med.service.MedicalTestService;

@RestController
@RequestMapping(value = RestCallUrl.MEDICAL_TEST_REST_BASE_URL, produces = { "application/JSON" })
public class MedicalTestController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	MedicalTestService medicalTestService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.ADD_MEDICAL_TEST_DETAILS_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> addTest(@RequestBody MedicalTestModel medicalTestModelReq) throws CommonException {

		logger.debug("addTest() :: medicalTestModel : " + medicalTestModelReq);
		medicalTestModelReq.setTestId(null);
		logger.debug("addTest() :: medicalTestModel : " + medicalTestModelReq);

		MedicalTestModel medicalTestModelRes;
		try {
			medicalTestModelRes = medicalTestService.addTest(medicalTestModelReq);
			logger.debug("addTest() :: medicalTestModel : {}", medicalTestModelRes);
		} catch (CommonException e) {
			logger.error("addTest() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(medicalTestModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.UPDATE_MEDICAL_TEST_DETAILS_URL, method = RequestMethod.POST)
	public ResponseEntity<Response> updateTest(@RequestBody MedicalTestModel medicalTestModelReq)
			throws CommonException {

		logger.debug("updateTest() :: medicalTestModel : " + medicalTestModelReq);

		MedicalTestModel medicalTestModelRes;
		try {
			medicalTestModelRes = medicalTestService.updateTest(medicalTestModelReq);
			logger.debug("updateTest() :: medicalTestModel : {}", medicalTestModelRes);
		} catch (CommonException e) {
			logger.error("updateTest() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(medicalTestModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.DELETE_MEDICAL_TEST_DETAILS_BY_ID_URL, method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteTest(@RequestParam @Valid @Positive @NotNull Long testId)
			throws CommonException {

		logger.debug("deleteTest() :: testId : " + testId);

		try {
			medicalTestService.deleteTest(testId);
			logger.debug("deleteTest() :: {}");
		} catch (CommonException e) {
			logger.error("deleteTest() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_MEDICAL_TEST_DETAILS_BY_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getTestById(@RequestParam @Valid @Positive @NotNull Long testId)
			throws CommonException {

		logger.debug("getTestById() :: testId : " + testId);

		MedicalTestModel medicalTestModelRes;
		try {
			medicalTestModelRes = medicalTestService.getTestById(testId);
			logger.debug("getTestById() :: medicalTestModel : {}", medicalTestModelRes);
		} catch (CommonException e) {
			logger.error("getTestById() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(medicalTestModelRes), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_ALL_MEDICAL_TEST_DETAILS_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getAllTests() throws CommonException {

		logger.debug("getAllTests() :: ");

		List<MedicalTestModel> medicalTestModelListRes;
		try {
			medicalTestModelListRes = medicalTestService.getAllTests();
			logger.debug("getAllTests() :: medicalTestModel : {}", medicalTestModelListRes);
		} catch (CommonException e) {
			logger.error("getAllTests() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(medicalTestModelListRes), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestCallUrl.GET_MEDICAL_TEST_DETAILS_BY_PATIENT_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<Response> getTestByPatientId(@RequestParam @Valid @Positive @NotNull Long patientId) throws CommonException {

		logger.debug("getTestByPatientId() :: patientId : {} " + patientId);

		MedicalTestModel medicalTestModelRes;
		try {
			medicalTestModelRes = medicalTestService.getTestByPatientId(patientId);
			logger.debug("getTestByPatientId() :: medicalTestModel : {}", medicalTestModelRes);
		} catch (CommonException e) {
			logger.error("getTestByPatientId() :: UserServiceException : {}", e);
			return new ResponseEntity(Response.getFailureResponse(e.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(Response.getSuccessResponse(medicalTestModelRes), HttpStatus.OK);
	}
}
