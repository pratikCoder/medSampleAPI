package com.project.med.service;

import java.util.List;

import com.project.med.common.exception.CommonException;
import com.project.med.model.MedicalTestModel;

public interface MedicalTestService {

	public MedicalTestModel addTest(MedicalTestModel medicalTestModel) throws CommonException;

	public MedicalTestModel updateTest(MedicalTestModel medicalTestModel) throws CommonException;

	public void deleteTest(Long tsetId) throws CommonException;

	public MedicalTestModel getTestById(Long testId) throws CommonException;

	public List<MedicalTestModel> getAllTests() throws CommonException;

	public MedicalTestModel getTestByPatientId(Long patientId) throws CommonException;
	
	public Boolean medicalTestIsExistById(Long medicalTestId) throws CommonException;

}
