package com.project.med.common.constants;

public enum BloodGroupsEnum {

	// Common Java Provider Exceptions

	BLOOD_GROUP_A_NEGATIVE("bg01", "A -ve"), 
	BLOOD_GROUP_A_POSITIVE("bg02", "A +ve"), 
	BLOOD_GROUP_B_NEGATIVE("bg03",	"B -ve"), 
	BLOOD_GROUP_B_POSITIVE("bg04", "B +ve"), 
	BLOOD_GROUP_AB_NEGATIVE("bg05",	"AB -ve"), 
	BLOOD_GROUP_AB_POSITIVE("bg06", "AB +ve"), 
	BLOOD_GROUP_O_NEGATIVE("bg07", "O -ve"), 
	BLOOD_GROUP_O_POSITIVE("bg08", "O +ve")
	;

	private String bloodGroupCode;
	private String bloodGroupMsg;

	BloodGroupsEnum(String bloodGroupCode, String bloodGroupMsg) {
		this.bloodGroupCode = bloodGroupCode;
		this.bloodGroupMsg = bloodGroupMsg;
	}

	public String getBloodGroupCode() {
		return bloodGroupCode;
	}

	public void setBloodGroupCode(String bloodGroupCode) {
		this.bloodGroupCode = bloodGroupCode;
	}

	public String getBloodGroupMsg() {
		return bloodGroupMsg;
	}

	public void setBloodGroupMsg(String bloodGroupMsg) {
		this.bloodGroupMsg = bloodGroupMsg;
	}

}
