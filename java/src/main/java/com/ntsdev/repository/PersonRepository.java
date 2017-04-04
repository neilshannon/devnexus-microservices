package com.ntsdev.repository;


import com.ntsdev.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Sets up a Spring Data MongoDB repository for the `people` collection and a REST endpoint.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstName(@Param("name") String name);
}
