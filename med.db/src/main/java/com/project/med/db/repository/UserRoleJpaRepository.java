package com.project.med.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.med.db.entity.UserRoleEntity;

public interface UserRoleJpaRepository extends JpaRepository<UserRoleEntity, Long> {

	UserRoleEntity getUserByRoleTitle(String roleTitle);

	Boolean existsByRoleTitle(String roleTitle);

}
