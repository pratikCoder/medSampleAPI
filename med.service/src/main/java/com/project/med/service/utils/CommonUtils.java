package com.project.med.service.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;

@Component
public class CommonUtils {

	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static Date currentDate() {
		logger.debug("currentDate() :: ");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		Date date = new Date();
		dateFormat.format(date);
		logger.debug("currentDate() :: date : {}", date);
		return date;
	}

	public static Long getCurrentTimeInMills() {
		return System.currentTimeMillis();
	}

	public static void IdsValidate(Long id) throws CommonException {
		logger.debug("IdsValidate() :: Id : " + id);

		if (id <= 0 || id.equals(null)) {
			logger.error("IdsValidate() :: id : errorMessages : {} ", ErrorMessages.ID_IS_INVALID);

			throw new CommonException(ErrorMessages.ID_IS_INVALID);
		}
	}
}
