package com.educo.libraryModule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educo.libraryModule.models.LibraryModel;

public interface LibraryRepository extends MongoRepository<LibraryModel, String> {

}
