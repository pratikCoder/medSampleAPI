package com.project.med.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;
import com.project.med.model.UserRoleModel;

@Component
public class UserUtils {

	private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

	public static void emailValidate(String email) throws CommonException {
		logger.debug("emailValidate() :: email : " + email);

		if (StringUtils.isEmpty(email)) {
			logger.error("emailValidate() :: emailId : errorMessages : {} ", ErrorMessages.USER_EMAIL_EMPTY);

			throw new CommonException(ErrorMessages.USER_EMAIL_EMPTY);
		}
		if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,25}$")) {
			logger.error("emailValidate() :: emailId : errorMessages : {} ", ErrorMessages.USER_EMAIL_INVALID);
			
			System.out.println(email + "  <=== email");

			throw new CommonException(ErrorMessages.USER_EMAIL_INVALID);
		}
		return;
	}

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

	public static void userNameValidate(String f_name, String l_name) throws CommonException {
		logger.debug("userNameValidate() :: f_name : " + f_name + " l_name : " + l_name);
		if (StringUtils.isEmpty(f_name)) {
			logger.error("userNameValidate() :: f_name : errorMessages : {} ", ErrorMessages.USER_EMAIL_EMPTY);

			throw new CommonException(ErrorMessages.FIRST_NAME_EMPTY);
		}
		if (StringUtils.isEmpty(l_name)) {
			logger.error("userNameValidate() :: l_name : errorMessages : {} ", ErrorMessages.USER_EMAIL_EMPTY);

			throw new CommonException(ErrorMessages.LAST_NAME_EMPTY);
		}
		if (!f_name.matches("[a-zA-Z]{3,30}")) {

			logger.error("userNameValidate() :: f_name : errorMessages : {} ",
					ErrorMessages.FIRST_NAME_STRING_INCORRECT);

			throw new CommonException(ErrorMessages.FIRST_NAME_STRING_INCORRECT);
		}

		if (!l_name.matches("[a-zA-Z]{3,30}")) {

			logger.error("userNameValidate() :: l_name : errorMessages : {} ",
					ErrorMessages.LAST_NAME_STRING_INCORRECT);

			throw new CommonException(ErrorMessages.LAST_NAME_STRING_INCORRECT);
		}
	}

	public static void passwordValidate(String password, String rePassword) throws CommonException {
		logger.debug("passwordValidate() :: password : rePassword : " + password + rePassword);

		if (StringUtils.isEmpty(password)) {
			logger.error("passwordValidate() :: password : errorMessages : {} ", ErrorMessages.PASSWORD_EMPTY);

			throw new CommonException(ErrorMessages.PASSWORD_EMPTY);
		}
		if (StringUtils.isEmpty(rePassword)) {
			logger.error("passwordValidate() :: password : errorMessages : {} ", ErrorMessages.RE_PASSWORD_EMPTY);

			throw new CommonException(ErrorMessages.RE_PASSWORD_EMPTY);
		}
		if (!password.matches("^([a-zA-Z0-9@!$%*#]{8,15})$")) {

			// Password matching expression. Match all alphanumeric character
			// and predefined wild characters. Password must consists of at
			// least 8 characters and not more than 15 characters.
			// Examples : @12X*567 | 1#Zv96g@*Yfasd4 | #67jhgt@erd
			
			System.out.println("password =====> " + password);

			logger.error("passwordValidate() :: password : errorMessages : {} ",
					ErrorMessages.PASSWORD_STRING_IS_INCORRECT);

			throw new CommonException(ErrorMessages.PASSWORD_STRING_IS_INCORRECT);
		}
	}

	public static void roleValidate(UserRoleModel userRoleModel) throws CommonException {
		logger.debug("roleValidate() :: userRoleModel : " + userRoleModel);

		if (userRoleModel.equals(null)) {
			logger.error("roleValidate() :: userRoleModel : errorMessages : {} ", ErrorMessages.USER_ROLE_IS_EMPTY);

			throw new CommonException(ErrorMessages.USER_ROLE_IS_EMPTY);
		}
	}

	public static boolean checkPassword(String password, String dbPassword) throws CommonException {
		if ((password.compareTo(dbPassword) == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean matchPassword(String password1, String password2) throws CommonException {
		boolean flag2 = true;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!(passwordEncoder.matches(password1, password2))) {
			flag2 = false;
		}
		if (flag2)
			return true;
		else
			return false;
	}

}
