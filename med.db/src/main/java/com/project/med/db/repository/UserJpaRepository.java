package com.project.med.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.med.db.entity.UserEntity;

public interface UserJpaRepository
		extends JpaRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmailId(String emailId);

	UserEntity getUserByEmailId(String emailId);

}
