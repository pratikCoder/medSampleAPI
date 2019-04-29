package com.project.med.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.med.common.constants.ErrorMessages;
import com.project.med.common.exception.CommonException;
import com.project.med.service.UserAuth;
import com.project.med.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;

	@Autowired
	UserAuth userAuth;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@SuppressWarnings("serial")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		Authentication auth = null;
		String exceptionMessage = "";
		String name = String.valueOf(authentication.getPrincipal());
		try {
			Boolean isValidUser = userService.validateUser(name, String.valueOf(authentication.getCredentials()));
			if (isValidUser) {

				userAuth = userService.getUserAuthorizationByEmailId(name);

				if (!userAuth.getUser().getIsActive()) {
					throw new CommonException(ErrorMessages.USER_IS_INAVCTIV);
				}

				if (!passwordEncoder.matches(String.valueOf(authentication.getCredentials()),
						userAuth.getUser().getPassword())) {
					throw new CommonException(ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
				}
				auth = new UsernamePasswordAuthenticationToken(userAuth.getUser().getEmailId(),
						userAuth.getUser().getPassword(), userAuth.getAuthoritiesList());
			}
		} catch (Exception e) {
			exceptionMessage = e.getMessage().replace("\"", "");
		} finally {
			if (auth == null) {
				logger.error(exceptionMessage);
				throw new AuthenticationException(exceptionMessage) {
				};
			}
		}
		return auth;
	}
}
