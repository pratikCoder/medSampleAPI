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
import com.project.med.db.entity.PatientEntity;
import com.project.med.db.repository.PatientJpaRepository;
import com.project.med.model.PatientModel;
import com.project.med.service.PatientService;
import com.project.med.service.utils.CommonUtils;
import com.project.med.service.utils.PatientUtils;

@Service
public class PatientServiceImpl implements PatientService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private PatientJpaRepository patientJpaRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PatientModel addPatient(PatientModel patientModel) throws CommonException {
		logger.debug("addPatient() :: patientModel : " + patientModel);
		
		System.out.println("addPatient() : " + patientModel);

		PatientUtils.ageValidate(patientModel.getPatientAge());
		PatientUtils.genderValidate(patientModel.getPatientGender());
		PatientUtils.mobileValidate(patientModel.getPatientMobileNumber());
		PatientUtils.userFirstNameValidate(patientModel.getPatientFirstName());
		PatientUtils.userLastNameValidate(patientModel.getPatientLastName());

		PatientEntity patientEntity = new PatientEntity();
		modelMapper.map(patientModel, patientEntity);

		patientEntity = patientJpaRepo.saveAndFlush(patientEntity);
		modelMapper.map(patientEntity, patientModel);

		logger.debug("addPatient() :: patientModel : " + patientModel);
		return patientModel;
	}

	@Override
	public PatientModel updatePatient(PatientModel patientModel) throws CommonException {
		logger.debug("updatePatient() :: patientModel : " + patientModel);

		CommonUtils.IdsValidate(patientModel.getPatientId());
		patientIsExistByID(patientModel.getPatientId());

		PatientEntity patientEntity = new PatientEntity();
		modelMapper.map(patientModel, patientEntity);

		patientEntity = patientJpaRepo.saveAndFlush(patientEntity);
		modelMapper.map(patientEntity, patientModel);
		logger.debug("updatePatient() :: patientModel : " + patientModel);
		return patientModel;
	}

	@Override
	public void deletePatient(Long patientId) throws CommonException {
		logger.debug("deletePatient() :: patientId : " + patientId);

		CommonUtils.IdsValidate(patientId);
		patientIsExistByID(patientId);

		patientJpaRepo.deleteById(patientId);

		logger.debug("deletePatient()");
		return;
	}

	@Override
	public PatientModel getPatientById(Long patientId) throws CommonException {
		logger.debug("getPatientById() :: patientId : " + patientId);

		CommonUtils.IdsValidate(patientId);
		patientIsExistByID(patientId);

		PatientEntity patientEntity = new PatientEntity();
		PatientModel patientModel = new PatientModel();

		patientEntity = patientJpaRepo.getOne(patientId);

		modelMapper.map(patientEntity, patientModel);

		logger.debug("getPatientById() :: patientModel : " + patientModel);
		return patientModel;
	}

	@Override
	public List<PatientModel> getAllPatients() throws CommonException {
		logger.debug("getAllPatients() :: ");

		List<PatientEntity> patientEntityList = new ArrayList<PatientEntity>();
		List<PatientModel> patientModelList = new ArrayList<PatientModel>();

		patientEntityList = patientJpaRepo.findAll();

		for (int i = 0; i < patientEntityList.size(); i++) {
			PatientModel patientModel = new PatientModel();

			PatientEntity patientEntity = patientEntityList.get(i);
			modelMapper.map(patientEntity, patientModel);

			patientModelList.add(patientModel);
		}

		logger.debug("getAllPatients() :: patientModelList : " + patientModelList);
		return patientModelList;
	}

	@Override
	public PatientModel getPatientByName(String first_name) throws CommonException {
		logger.debug("getPatientByName() :: first_name : " + first_name);

		PatientUtils.userFirstNameValidate(first_name);

		PatientEntity patientEntity = new PatientEntity();
		PatientModel patientModel = new PatientModel();

		patientEntity = patientJpaRepo.getByPatientFirstName(first_name);

		modelMapper.map(patientEntity, patientModel);

		logger.debug("getPatientByName() :: patientModel : " + patientModel);
		return patientModel;
	}

	@Override
	public Boolean patientIsExistByID(Long patientId) throws CommonException {
		logger.debug("patientIsExistByID() :: patientId : " + patientId);
		Boolean isExist = false;

		isExist = patientJpaRepo.existsById(patientId);
		if (isExist == false) {
			logger.error("patientIsExistByID() :: patientId : errorMessages : {} ", ErrorMessages.UNAVAILABLE_PATIENT_ID);

			throw new CommonException(ErrorMessages.UNAVAILABLE_PATIENT_ID);
		}
		return isExist;
	}

}
