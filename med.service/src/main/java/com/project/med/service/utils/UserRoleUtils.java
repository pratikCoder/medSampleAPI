package com.project.med.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;

@Component
public class UserRoleUtils {

	private static Logger logger = LoggerFactory.getLogger(UserRoleUtils.class);

	public static void roleTitleValidate(String roleTitle) throws CommonException {
		logger.debug("roleTitleValidate() :: roleTitle : " + roleTitle);

		if (StringUtils.isEmpty(roleTitle)) {
			logger.error("roleTitleValidate() :: roleTitle : errorMessages : {} ", ErrorMessages.USER_ROLE_IS_EMPTY);

			throw new CommonException(ErrorMessages.USER_ROLE_IS_EMPTY);
		}

		return;
	}

}
