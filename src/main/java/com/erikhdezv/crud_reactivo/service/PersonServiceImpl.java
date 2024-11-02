package com.erikhdezv.crud_reactivo.service;

import com.erikhdezv.crud_reactivo.model.Person;
import com.erikhdezv.crud_reactivo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> update(Person person, Integer id) {
        return personRepository.findById(id)
                .flatMap(people -> {
                    people.setName(person.getName());
                    people.setAge(person.getAge());
                    people.setGender(person.getGender());
                    people.setDate_of_birth(person.getDate_of_birth());
                    people.setBlood_type(person.getBlood_type());
                    return personRepository.save(people);
                });
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return personRepository.deleteById(id);
    }
}
