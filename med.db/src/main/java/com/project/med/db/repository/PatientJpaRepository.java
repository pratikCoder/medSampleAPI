package com.project.med.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.med.db.entity.PatientEntity;

public interface PatientJpaRepository extends JpaRepository<PatientEntity, Long> {

	public PatientEntity getByPatientFirstName(String first_name);
}
