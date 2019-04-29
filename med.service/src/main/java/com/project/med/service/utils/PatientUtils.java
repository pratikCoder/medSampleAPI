package com.project.med.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;

public class PatientUtils {

	private static Logger logger = LoggerFactory.getLogger(PatientUtils.class);

	public static void mobileValidate(Long mbl) throws CommonException {
		logger.debug("mobileValidate() :: mblNo : " + mbl);

		if (!mbl.toString().matches("^[789]\\d{9}$")) {

			// ^ #Match the beginning of the string
			// [789] #Match a 7, 8 or 9
			// \d #Match a digit (0-9 and anything else that is a "digit" in the
			// regex engine)
			// {9} #Repeat the previous "\d" 9 times (9 digits)
			// $ #Match the end of the string

			// OR used Expression :
			// ^((\+){0,1}91(\s){0,1}(\-){0,1}(\s){0,1}){0,1}98(\s){0,1}(\-){0,1}(\s){0,1}[1-9]{1}[0-9]{7}$
			// ^[6-9]\d{9}$
			// etc.

			logger.error("mobileValidate() :: mblNo : errorMessages : {} ", ErrorMessages.MOBILE_NO_IS_INCORRECT);

			throw new CommonException(ErrorMessages.MOBILE_NO_IS_INCORRECT);
		}
	}

	public static void genderValidate(String gender) throws CommonException {
		logger.debug("genderValidate() :: gender : " + gender);

		if (StringUtils.isEmpty(gender)) {
			logger.error("genderValidate() :: gender : errorMessages : {} ", ErrorMessages.PATIENT_GENDER_IS_EMPTY);

			throw new CommonException(ErrorMessages.PATIENT_GENDER_IS_EMPTY);
		}
		if (! (gender.equals("MALE") || gender.equals("FEMALE"))) {
			logger.error("genderValidate() :: gender : errorMessages : {} ", ErrorMessages.PATIENT_GENDER_IS_INVALID);

			throw new CommonException(ErrorMessages.PATIENT_GENDER_IS_INVALID);
		}
		return ;
	}

	public static void ageValidate(Long age) throws CommonException {
		logger.debug("ageValidate() :: age : " + age);

		if (StringUtils.isEmpty(age)) {
			logger.error("ageValidate() :: age : errorMessages : {} ", ErrorMessages.PATIENT_AGE_IS_EMPTY);

			throw new CommonException(ErrorMessages.PATIENT_AGE_IS_EMPTY);
		}

		if (age <= 0 || age > 120) {
			logger.error("ageValidate() :: age : errorMessages : {} ", ErrorMessages.PATIENT_AGE_IS_INVALID);

			throw new CommonException(ErrorMessages.PATIENT_AGE_IS_INVALID);
		}
	}

	public static void userFirstNameValidate(String f_name) throws CommonException {
		logger.debug("userNameValidate() :: f_name : " + f_name);
		if (StringUtils.isEmpty(f_name)) {
			logger.error("userNameValidate() :: f_name : errorMessages : {} ", ErrorMessages.USER_EMAIL_EMPTY);

			throw new CommonException(ErrorMessages.FIRST_NAME_EMPTY);
		}

		if (!f_name.toString().matches("[a-zA-Z]{3,30}")) {

			logger.error("userNameValidate() :: f_name : errorMessages : {} ",
					ErrorMessages.FIRST_NAME_STRING_INCORRECT);

			throw new CommonException(ErrorMessages.FIRST_NAME_STRING_INCORRECT);
		}

	}

	public static void userLastNameValidate(String l_name) throws CommonException {
		logger.debug("userNameValidate() :: l_name : " + l_name);
		if (StringUtils.isEmpty(l_name)) {
			logger.error("userNameValidate() :: l_name : errorMessages : {} ", ErrorMessages.USER_EMAIL_EMPTY);

			throw new CommonException(ErrorMessages.LAST_NAME_EMPTY);
		}
		if (!l_name.matches("[a-zA-Z]{3,30}")) {

			logger.error("userNameValidate() :: l_name : errorMessages : {} ",
					ErrorMessages.LAST_NAME_STRING_INCORRECT);

			throw new CommonException(ErrorMessages.LAST_NAME_STRING_INCORRECT);
		}
	}
}
