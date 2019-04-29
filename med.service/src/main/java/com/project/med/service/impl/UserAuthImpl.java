package com.project.med.service.impl;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.project.med.db.entity.UserEntity;
import com.project.med.service.UserAuth;

@Component
public class UserAuthImpl implements UserAuth {

	private UserEntity userEntity;
	List<GrantedAuthority> authoritiesList;

	@Override
	public UserEntity getUser() {
		return userEntity;
	}

	@Override
	public void setUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public void setAuthoritiesList(List<GrantedAuthority> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}

	@Override
	public List<GrantedAuthority> getAuthoritiesList() {
		return authoritiesList;
	}

}
