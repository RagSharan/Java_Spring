package com.educo.authModule.service.serviceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.educo.authModule.exception.RoleNotFoundException;
import com.educo.authModule.exception.UserAlreadyRegisterException;
import com.educo.authModule.exception.UserNotFoundException;
import com.educo.authModule.model.Credential;
import com.educo.authModule.model.Role;
import com.educo.authModule.model.ApplicationUser;
import com.educo.authModule.model.UserDTO;
import com.educo.authModule.repository.CredentialRepository;
import com.educo.authModule.repository.RoleRepository;
import com.educo.authModule.repository.UserRepository;
import com.educo.authModule.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	
	
	@Autowired
	private CredentialRepository credentialRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	
	/*@Override
	public String loginUser(Credential credential) {
		boolean exists = isCredntialExist(credential);
		if(!exists) {
			throw new UserNotFoundException("User does not exist. Please register with us");
		}
		Optional<Credential> optional = credentialRepo.findByEmail(credential.getEmail());
		if(optional.isPresent() && optional.get().getId() != null) {
			jwtToken = tokenService.generateToken(credential);
		}
		return jwtToken;
	}*/
	
	@Override
	public ApplicationUser getUserByname(String username) {
		Optional<ApplicationUser> optional = userRepo.findByUsername(username);
		if(!optional.isPresent()) {
			throw new UserNotFoundException(username + "User is not present");
		}
		ApplicationUser user = optional.get();
		return user;
	}
	
	@Override
	public Credential registerUser(UserDTO userDTO)  {
		Credential credential = new Credential();
		credential.setEmail(UserDTO.getEmail());
		credential.setPassword(bcryptEncoder.encode(UserDTO.getPassword()));
		boolean exists = isCredntialExist(credential);
		if(exists) {
			throw new UserAlreadyRegisterException("User is already registered. Please reset password if you have forget password");
		}
		credential = credentialRepo.save(credential);
		ApplicationUser user = new ApplicationUser();
		user.setId(credential.getId());
		user.setEmail(credential.getEmail());
		user.setUsername(UserDTO.getUsername());
		user.setPhone(UserDTO.getPhone());
		Optional<Role> role = roleRepo.findByRolename(UserDTO.getRolename());
		if(role.isPresent()) {
			Set<String> roleIdSet = new HashSet<String>();
			roleIdSet.add(role.get().getId());
			user.setRoleIdSet(roleIdSet);
		}else {
			throw new RoleNotFoundException("User role is not present");
		}
		user = userRepo.insert(user);
		
		return credential;
	}
	
	private boolean isCredntialExist(Credential credential) {
		boolean exists = credentialRepo.existsByEmail(credential.getEmail());
		return exists;
	}

	@Override
	public String loginUser(Credential credential) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
		
}


