package com.project.med.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientEntity {

	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;

	@Column(name = "patient_first_name")
	private String patientFirstName;

	@Column(name = "patient_last_name")
	private String patientLastName;

	@Column(name = "patient_age")
	private Long patientAge;

	@Column(name = "patient_gender")
	private String patientGender;

	@Column(name = "patient_mobile")
	private Long patientMobileNumber;

	public PatientEntity() {
		super();
	}

	public PatientEntity(Long patientId, String patientFirstName, String patientLastName, Long patientAge,
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
		return "PatientEntity [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", patientAge=" + patientAge + ", patientGender=" + patientGender
				+ ", patientMobileNumber=" + patientMobileNumber + "]";
	}

}
