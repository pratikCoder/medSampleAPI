package com.project.med.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MedicalTestModel {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long testId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long patientId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean isSmoker;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean isAlcoholic;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String bloodGroup;

	public MedicalTestModel() {
		super();
	}

	public MedicalTestModel(Long testId, Long patientId, Boolean isSmoker, Boolean isAlcoholic, String bloodGroup) {
		super();
		this.testId = testId;
		this.patientId = patientId;
		this.isSmoker = isSmoker;
		this.isAlcoholic = isAlcoholic;
		this.bloodGroup = bloodGroup;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Boolean getIsSmoker() {
		return isSmoker;
	}

	public void setIsSmoker(Boolean isSmoker) {
		this.isSmoker = isSmoker;
	}

	public Boolean getIsAlcoholic() {
		return isAlcoholic;
	}

	public void setIsAlcoholic(Boolean isAlcoholic) {
		this.isAlcoholic = isAlcoholic;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "MedicalTest [testId=" + testId + ", patientId=" + patientId + ", isSmoker=" + isSmoker
				+ ", isAlcoholic=" + isAlcoholic + ", bloodGroup=" + bloodGroup + "]";
	}

}
