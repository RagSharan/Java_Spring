package com.educo.authModule.model;

public class UserDTO {
	
	private static String username;
	
	private static String password;
	
	private static String email;
	
	private static String rolename;
	
	private static String phone;

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		UserDTO.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		UserDTO.password = password;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		UserDTO.email = email;
	}

	public static String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		UserDTO.rolename = rolename;
	}

	public static String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		UserDTO.phone = phone;
	}

}
