package com.educo.authModule.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="application_user")
public class ApplicationUser {
	
	@Id
	private String id;
	
	private String username;
	
	private String email;
	
	private String phone;
	
	private Set<String> roleIdSet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<String> getRoleIdSet() {
		return roleIdSet;
	}

	public void setRoleIdSet(Set<String> roleIdSet) {
		this.roleIdSet = roleIdSet;
	}
	
	

}
