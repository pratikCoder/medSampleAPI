package com.project.med.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.med.db.entity.MedicalTestEntity;

public interface MedicalTestJpaRepository extends JpaRepository<MedicalTestEntity, Long> {

	public MedicalTestEntity getByPatientId(Long patientId);

}
