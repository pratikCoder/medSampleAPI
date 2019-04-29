package com.project.med.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.med.db.entity.UserEntity;
import com.project.med.service.impl.UserAuthImpl;

@JsonDeserialize(as = UserAuthImpl.class)
public interface UserAuth {

	UserEntity getUser();

	void setUser(UserEntity user);

	public void setAuthoritiesList(List<GrantedAuthority> authoritiesList);

	public List<GrantedAuthority> getAuthoritiesList();

}