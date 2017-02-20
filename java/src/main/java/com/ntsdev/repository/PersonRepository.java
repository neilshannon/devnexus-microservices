package com.ntsdev.repository;


import com.ntsdev.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Sets up a Spring Data MongoDB repository for the `people` collection and a REST endpoint.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {

}
