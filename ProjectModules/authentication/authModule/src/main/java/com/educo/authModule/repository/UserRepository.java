package com.educo.authModule.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educo.authModule.model.ApplicationUser;

public interface UserRepository extends MongoRepository<ApplicationUser, String> {

	Optional<ApplicationUser> findByUsername(String username);

}
