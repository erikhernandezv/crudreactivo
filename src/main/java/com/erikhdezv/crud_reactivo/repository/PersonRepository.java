package com.erikhdezv.crud_reactivo.repository;

import com.erikhdezv.crud_reactivo.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {
}
