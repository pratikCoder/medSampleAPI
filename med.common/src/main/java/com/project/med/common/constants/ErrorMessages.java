package com.project.med.common.constants;

public enum ErrorMessages {
	
	// Common Java Provider Exceptions
	
	NULL_POINTER_EXCEPTION("med001", "Value is Null"),
	
	
	// Login Error Messages
	LOGIN_FAILED("100", "Login Failed"),
	INVALID_USERNAME_AND_PASSWORD("med101", "Invalid Username and Password"),
	REGISTRATION_FAILED("med102", "Registration Failed"),
	
	// User Error Messages
	USER_EMAIL_INVALID("med201","Invalid Email id"),
	USER_EMAIL_EMPTY("med202","Empty Email id string"),
	USER_MOBILE_NO_INVALID("med203","Invalid Mobile number"),
	FIRST_NAME_EMPTY("med204","Empty First Name string"),
	LAST_NAME_EMPTY("med205","Empty Last Name string"),
	FIRST_NAME_STRING_INCORRECT("med204_1","First Name must be string"),
	LAST_NAME_STRING_INCORRECT("med205_1","Last Name must be string"),
	PASSWORD_EMPTY("med206","Empty Password string"),
	RE_PASSWORD_EMPTY("med206_1","Empty Re-Password string"),
	PASSWORD_NOT_MATCHES("med207","Password and Confirm Password is not matched"),
	PASSWORD_STRING_IS_INCORRECT("med208","Password must be in between 8 to 16 characters with atleast 1 number, small letter, capital letter or special character"),
	USER_ID_INVALID("med209","Invalid User ID"),
	UNAVAILABLE_USER_ID("med210","Unavailable User ID"),
	USER_DOES_NOT_EXISTS("med211","User Not Found"),
	USER_IS_NOT_VERIFIED("med212","User is not Verified"),
	USER_IS_INAVCTIV("med213","User is in-active"),
	USER_IS_NOT_FOUND("med214","User is not found"),
	
	// User Role Error Messages
	USER_IS_NOT_ADMIN("med301","User is not Admin"),
	USER_ROLE_IS_EMPTY("med302","User rOLE is not Empty"),
	UNAVAILABLE_USER_ROLE_ID("med303","Unavailable User Role ID"),
	UNAVAILABLE_USER_ROLE_TITLE("med304","Unavailable User Role Title"),
	
	// Common Error Messages
	ID_IS_INVALID("med001","ID is Invalid"),
	MOBILE_NO_IS_INCORRECT("med002","Mobile nume=ber must be 10 digit with start of 9,8,7 "),
	
	// Patient Error Messages
	PATIENT_GENDER_IS_INVALID("med401","Patient Gender is Invalid"),
	PATIENT_GENDER_IS_EMPTY("med402","Patient Gender is Empty"),
	PATIENT_AGE_IS_EMPTY("med403","Patient AGE is Empty"),
	PATIENT_AGE_IS_INVALID("med404","Patient AGE is Invalid"),
	UNAVAILABLE_PATIENT_ID("med405","Patient id is Invalid"),
	
	
	
	
	// Medical Test Error Messsage
	UNAVAILABLE_MEDICAL_TEST_ID("med501","Patient Medical Test id is Invalid"),
	MEDICAL_TEST_BLOOD_GROUP_IS_EMPTY("med502","Patient Medical Test Blood Group is Empty"),
	MEDICAL_TEST_BLOOD_GROUP_IS_INVALID("med503","Patient Medical Test Blood Group is Invalid"),
	
	
	
	
	;
	
    private String errorCode;    
    private String errorMsg;

    ErrorMessages(String errorCode, String errorMssg) {
    	this.errorCode = errorCode;
		this.errorMsg = errorMssg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
