package com.educo.authModule.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educo.authModule.model.AuthToken;
import com.educo.authModule.exception.UserNotFoundException;
import com.educo.authModule.model.Credential;
import com.educo.authModule.model.ApplicationUser;
import com.educo.authModule.model.UserDTO;
import com.educo.authModule.service.AuthenticationService;
import static com.educo.authModule.model.Constants.*;



@RequestMapping("/authUser")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class AuthController {

	@Autowired
	AuthenticationService authenticationService;	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private com.educo.authModule.configuration.TokenProvider jwtTokenUtil;
	
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping("/getUser/{username}")
	public ResponseEntity<ApplicationUser> getUser(@PathVariable String username){
		ResponseEntity<ApplicationUser> response = null;
		boolean auth = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		if(auth) {
			System.out.println("Authenticated");
		}
		ApplicationUser user = authenticationService.getUserByname(username);
		if(user == null) {
			throw new UserNotFoundException(username+ " is not found");
		}
		response = new ResponseEntity<>(user, HttpStatus.FOUND);
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthToken> authenticateUser(@RequestBody Credential credential){
		 final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		credential.getEmail(),
	                		credential.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = TOKEN_PREFIX + jwtTokenUtil.generateToken(authentication);
	        
	        return ResponseEntity.ok(new AuthToken(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthToken> registerUser(@RequestBody @Valid UserDTO user) {
		Credential credential = authenticationService.registerUser(user);
		 final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		credential.getEmail(),
	                		user.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = TOKEN_PREFIX + jwtTokenUtil.generateToken(authentication);
	        
	        return ResponseEntity.ok(new AuthToken(token));
	}
	
}
