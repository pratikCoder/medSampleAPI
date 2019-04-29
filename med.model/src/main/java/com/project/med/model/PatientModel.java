package com.project.med.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PatientModel {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long patientId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String patientFirstName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String patientLastName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long patientAge;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String patientGender;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long patientMobileNumber;

	public PatientModel() {
		super();
	}

	public PatientModel(Long patientId, String patientFirstName, String patientLastName, Long patientAge,
			String patientGender, Long patientMobileNumber) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientMobileNumber = patientMobileNumber;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public Long getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Long patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public Long getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(Long patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	@Override
	public String toString() {
		return "PatientModel [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", patientAge=" + patientAge + ", patientGender=" + patientGender
				+ ", patientMobileNumber=" + patientMobileNumber + "]";
	}

}
