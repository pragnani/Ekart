package com.ekart.app.auth.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ekart.app.client.EkartWebClient;
import com.ekart.app.model.IUser;
import com.ekart.app.model.Role;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		try {

			EkartWebClient client = new EkartWebClient();

			if (password == null || password.trim().length() == 0) {
				throw new BadCredentialsException("Password Must not be empty");
			}

			String userCredentials = name + ":" + password;
			byte[] userBytes = userCredentials.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(userBytes);
			String base64CredString = new String(base64CredsBytes);
			IUser user = client.getByCredentials(base64CredString);

			if (user != null) {

				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				List<Role> roles = user.getRoles();
				if (roles != null) {
					for (Role role : roles) {
						grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
					}
				} else {
					throw new BadCredentialsException("Username or password Wrong");
				}
				return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
			} else {
				throw new BadCredentialsException("Username or password Wrong");
			}
		} catch (Exception e) {
			throw new BadCredentialsException("Username or password Wrong");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}