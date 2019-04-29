package com.project.med.service;

import java.util.List;

import com.project.med.common.exception.CommonException;
import com.project.med.model.PatientModel;

public interface PatientService {

	public PatientModel addPatient(PatientModel patientModel) throws CommonException;

	public PatientModel updatePatient(PatientModel patientModel) throws CommonException;

	public void deletePatient(Long patientId) throws CommonException;

	public PatientModel getPatientById(Long patientId) throws CommonException;

	public List<PatientModel> getAllPatients() throws CommonException;

	public PatientModel getPatientByName(String first_name) throws CommonException;

	public Boolean patientIsExistByID(Long patientId) throws CommonException;

}
