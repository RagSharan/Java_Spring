package com.educo.authModule.service;


import com.educo.authModule.model.Credential;
import com.educo.authModule.model.ApplicationUser;
import com.educo.authModule.model.UserDTO;

public interface AuthenticationService {

	Credential registerUser(UserDTO userDTO) ;

	ApplicationUser getUserByname(String username);

	String loginUser(Credential credential);

}
