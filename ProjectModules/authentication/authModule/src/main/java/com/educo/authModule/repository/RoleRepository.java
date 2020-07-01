package com.educo.authModule.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educo.authModule.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	public Optional<Role> findByRolename(String rolename);

}
