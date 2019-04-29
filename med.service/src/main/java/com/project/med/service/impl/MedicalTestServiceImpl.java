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
import com.project.med.db.entity.MedicalTestEntity;
import com.project.med.db.repository.MedicalTestJpaRepository;
import com.project.med.model.MedicalTestModel;
import com.project.med.service.MedicalTestService;
import com.project.med.service.PatientService;
import com.project.med.service.utils.CommonUtils;
import com.project.med.service.utils.MedicalTestUtils;

@Service
public class MedicalTestServiceImpl implements MedicalTestService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private MedicalTestJpaRepository medicalTestJpaRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PatientService patientService;

	@Override
	public MedicalTestModel addTest(MedicalTestModel medicalTestModel) throws CommonException {
		logger.debug("addTest() :: medicalTestModel : " + medicalTestModel);

		patientService.patientIsExistByID(medicalTestModel.getPatientId());
		MedicalTestUtils.bloodGroupValidate(medicalTestModel.getBloodGroup());

		MedicalTestEntity medicalTestEntity = new MedicalTestEntity();
		modelMapper.map(medicalTestModel, medicalTestEntity);

		medicalTestEntity = medicalTestJpaRepo.saveAndFlush(medicalTestEntity);
		modelMapper.map(medicalTestEntity, medicalTestModel);

		logger.debug("addTest() :: medicalTestModel : " + medicalTestModel);
		return medicalTestModel;
	}

	@Override
	public MedicalTestModel updateTest(MedicalTestModel medicalTestModel) throws CommonException {
		logger.debug("updateTest() :: medicalTestModel : " + medicalTestModel);

		CommonUtils.IdsValidate(medicalTestModel.getPatientId());
		CommonUtils.IdsValidate(medicalTestModel.getTestId());
		patientService.patientIsExistByID(medicalTestModel.getPatientId());
		medicalTestIsExistById(medicalTestModel.getTestId());
		MedicalTestUtils.bloodGroupValidate(medicalTestModel.getBloodGroup());

		MedicalTestEntity medicalTestEntity = new MedicalTestEntity();
		modelMapper.map(medicalTestModel, medicalTestEntity);

		medicalTestEntity = medicalTestJpaRepo.saveAndFlush(medicalTestEntity);
		modelMapper.map(medicalTestEntity, medicalTestModel);

		logger.debug("updateTest() :: medicalTestModel : " + medicalTestModel);
		return medicalTestModel;
	}

	@Override
	public void deleteTest(Long testId) throws CommonException {
		logger.debug("deleteTest() :: testId : " + testId);

		CommonUtils.IdsValidate(testId);
		medicalTestIsExistById(testId);

		medicalTestJpaRepo.deleteById(testId);

		logger.debug("deleteTest() :: ");
		return;
	}

	@Override
	public MedicalTestModel getTestById(Long testId) throws CommonException {
		logger.debug("getTestById() :: testId : " + testId);

		CommonUtils.IdsValidate(testId);
		medicalTestIsExistById(testId);

		MedicalTestEntity medicalTestEntity = new MedicalTestEntity();
		MedicalTestModel medicalTestModel = new MedicalTestModel();

		medicalTestEntity = medicalTestJpaRepo.getOne(testId);

		modelMapper.map(medicalTestEntity, medicalTestModel);

		logger.debug("getTestById() :: medicalTestModel : " + medicalTestModel);
		return medicalTestModel;
	}

	@Override
	public List<MedicalTestModel> getAllTests() throws CommonException {
		logger.debug("getAllTests() :: ");

		List<MedicalTestEntity> medicalTestEntityList = new ArrayList<MedicalTestEntity>();
		List<MedicalTestModel> medicalTestModelList = new ArrayList<MedicalTestModel>();

		medicalTestEntityList = medicalTestJpaRepo.findAll();

		for (int i = 0; i < medicalTestEntityList.size(); i++) {
			MedicalTestModel medicalTestModel = new MedicalTestModel();

			MedicalTestEntity medicalTestEntity = medicalTestEntityList.get(i);
			modelMapper.map(medicalTestEntity, medicalTestModel);

			medicalTestModelList.add(medicalTestModel);
		}

		logger.debug("getAllTests() :: medicalTestModelList : " + medicalTestModelList);
		return medicalTestModelList;
	}

	@Override
	public MedicalTestModel getTestByPatientId(Long patientId) throws CommonException {
		logger.debug("getTestByPatientId() :: patientId : " + patientId);

		CommonUtils.IdsValidate(patientId);
		patientService.patientIsExistByID(patientId);

		MedicalTestEntity medicalTestEntity = new MedicalTestEntity();
		MedicalTestModel medicalTestModel = new MedicalTestModel();

		medicalTestEntity = medicalTestJpaRepo.getByPatientId(patientId);

		modelMapper.map(medicalTestEntity, medicalTestModel);

		logger.debug("getTestByPatientId() :: medicalTestModel : " + medicalTestModel);
		return medicalTestModel;
	}

	@Override
	public Boolean medicalTestIsExistById(Long medicalTestId) throws CommonException {
		logger.debug("medicalTestIsExistById() :: medicalTestId : " + medicalTestId);

		CommonUtils.IdsValidate(medicalTestId);

		Boolean isExist = false;

		isExist = medicalTestJpaRepo.existsById(medicalTestId);
		if (isExist == false) {
			logger.error("medicalTestIsExistById() :: medicalTestId : errorMessages : {} ",
					ErrorMessages.UNAVAILABLE_MEDICAL_TEST_ID);

			throw new CommonException(ErrorMessages.UNAVAILABLE_MEDICAL_TEST_ID);
		}
		return isExist;
	}
}
