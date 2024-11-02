package com.erikhdezv.crud_reactivo.service;

import com.erikhdezv.crud_reactivo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    public Flux<Person> findAll();
    public Mono<Person> findById(Integer id);
    public Mono<Person> save(Person person);
    public Mono<Person> update(Person person, Integer id);
    public Mono<Void> delete(Integer id);
}
