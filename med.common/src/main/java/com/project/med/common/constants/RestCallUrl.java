package com.project.med.common.constants;

public class RestCallUrl {

	// USER URL's
	public static final String USER_REST_BASE_URL = "/user";
	public static final String ADD_USER_URL = "/add";
	public static final String UPDATE_USER_URL = "/update";
	public static final String DELETE_USER_BY_ID_URL = "/delete";
	public static final String GET_USER_BY_ID_URL = "/getByUserId";
	public static final String GET_ALL_USERS_URL = "/getAll";
	public static final String GET_USER_BY_EMAIL_ID_URL = "/getByEmailId";
//	public static final String POST_CHANGE_PASSWORD = "/change-password";

	// USER ROLE URL's
	public static final String USER_ROLE_REST_BASE_URL = "/role";
	public static final String ADD_USER_ROLE_URL = "/add";
	public static final String UPDATE_USER_ROLE_BY_ID_URL = "/update";
	public static final String DELETE_USER_ROLE_BY_ID_URL = "/delete";
	public static final String GET_USER_ROLE_BY_ID_URL = "/getByUserRoleId";
	public static final String GET_USER_ROLE_BY_TITLE_URL = "/getByUserRoleTitle";
	public static final String GET_ALL_USER_ROLES_URL = "/getAll";

	// PATIENT URL's
	public static final String PATIENT_REST_BASE_URL = "/patient";
	public static final String ADD_PATIENT_URL = "/add";
	public static final String UPDATE_PATIENT_URL = "/update";
	public static final String DELETE_PATIENT_BY_ID_URL = "/delete";
	public static final String GET_PATIENT_BY_ID_URL = "/getByPatientId";
	public static final String GET_PATIENT_BY_NAME_URL = "/getByPatientTitle";
	public static final String GET_ALL_PATIENT_URL = "/getAll";

	// MEDICAL TEST URL's
	public static final String MEDICAL_TEST_REST_BASE_URL = "/medicalTest";
	public static final String ADD_MEDICAL_TEST_DETAILS_URL = "/add";
	public static final String UPDATE_MEDICAL_TEST_DETAILS_URL = "/update";
	public static final String DELETE_MEDICAL_TEST_DETAILS_BY_ID_URL = "/delete";
	public static final String GET_MEDICAL_TEST_DETAILS_BY_ID_URL = "/getById";
	public static final String GET_ALL_MEDICAL_TEST_DETAILS_URL = "/getAll";
	public static final String GET_MEDICAL_TEST_DETAILS_BY_PATIENT_ID_URL = "/getByPatientId";

}
