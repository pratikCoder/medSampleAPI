package com.project.med.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_test")
public class MedicalTestEntity {

	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long testId;

	@Column(name = "patient_id")
	private Long patientId;

	@Column(name = "is_smoker")
	private Boolean isSmoker;

	@Column(name = "is_alcoholic")
	private Boolean isAlcoholic;

	@Column(name = "blood_group")
	private String bloodGroup;

	public MedicalTestEntity() {
		super();
	}

	public MedicalTestEntity(Long testId, Long patientId, Boolean isSmoker, Boolean isAlcoholic, String bloodGroup) {
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
		return "MedicalTestEntity [testId=" + testId + ", patientId=" + patientId + ", isSmoker=" + isSmoker
				+ ", isAlcoholic=" + isAlcoholic + ", bloodGroup=" + bloodGroup + "]";
	}

}
