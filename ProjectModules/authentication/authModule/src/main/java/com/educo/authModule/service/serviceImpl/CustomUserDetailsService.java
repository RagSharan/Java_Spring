package com.educo.authModule.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.educo.authModule.exception.UserNotFoundException;
import com.educo.authModule.model.Credential;
import com.educo.authModule.repository.CredentialRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	CredentialRepository credRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential appUser = loadCredentialByEmail(username);
		return new User(appUser.getEmail(), appUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_TEACHER", "ROLE_ADMIN"));
	}

	public Credential loadCredentialByEmail(String email) {
		Optional<Credential> credential = credRepo.findByEmail(email);
		if(!credential.isPresent()) {
			throw new UserNotFoundException("User is not registered");
		}
		return credential.get();
	}
}
