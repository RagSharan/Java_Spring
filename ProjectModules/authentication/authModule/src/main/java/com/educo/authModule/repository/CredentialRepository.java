package com.educo.authModule.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educo.authModule.model.Credential;

public interface CredentialRepository extends MongoRepository<Credential, String> {

	boolean existsByEmail(String email);

	Optional<Credential> findByEmail(String email);

}
