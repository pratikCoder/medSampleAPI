package com.project.med.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.project.med.common.constants.BloodGroupsEnum;
import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;

public class MedicalTestUtils {

	private static Logger logger = LoggerFactory.getLogger(MedicalTestUtils.class);

	public static void bloodGroupValidate(String bloodGroup) throws CommonException {
		logger.debug("bloodGroupValidate() :: bloodGroup : " + bloodGroup);

		if (StringUtils.isEmpty(bloodGroup)) {
			logger.error("bloodGroupValidate() :: bloodGroup : errorMessages : {} ",
					ErrorMessages.MEDICAL_TEST_BLOOD_GROUP_IS_EMPTY);

			throw new CommonException(ErrorMessages.MEDICAL_TEST_BLOOD_GROUP_IS_EMPTY);
		}

		if ((bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_A_NEGATIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_AB_NEGATIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_B_NEGATIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_O_NEGATIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_A_POSITIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_AB_POSITIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_B_POSITIVE)
				|| bloodGroup.equals(BloodGroupsEnum.BLOOD_GROUP_O_POSITIVE))) {

			logger.error("bloodGroupValidate() :: bloodGroup : errorMessages : {} ",
					ErrorMessages.MEDICAL_TEST_BLOOD_GROUP_IS_INVALID);

			throw new CommonException(ErrorMessages.MEDICAL_TEST_BLOOD_GROUP_IS_INVALID);
		}

	}

}
