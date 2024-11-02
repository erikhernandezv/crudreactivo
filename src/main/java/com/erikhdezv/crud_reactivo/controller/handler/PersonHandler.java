package com.erikhdezv.crud_reactivo.controller.handler;

import com.erikhdezv.crud_reactivo.model.Person;
import com.erikhdezv.crud_reactivo.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

    private final PersonService personService;

    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> allPerson(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.findAll(), Person.class);
    }

    public Mono<ServerResponse> personById(ServerRequest request){
        return personService.findById(
                        Integer.valueOf( request.pathVariable("id"))
                )
                .flatMap(person -> ServerResponse.ok().bodyValue( person ))
                .switchIfEmpty( ServerResponse.notFound().build() );
    }

    public Mono<ServerResponse> savePerson(ServerRequest request){
        return request.bodyToMono(Person.class)
                .flatMap(personService::save)
                .flatMap(person -> ServerResponse.ok().bodyValue(person));
    }

    public Mono<ServerResponse> updatePerson(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id"));
        Mono<Person> personMono = request.bodyToMono(Person.class);

        return personMono
                .flatMap(person -> personService.update(person, id))
                .flatMap(peopleUpd -> ServerResponse.ok().bodyValue(peopleUpd))
                .switchIfEmpty( ServerResponse.notFound().build() );
    }

    public Mono<ServerResponse> deletePerson(ServerRequest request){
        return personService.delete( Integer.valueOf( request.pathVariable("id") ))
                .then( ServerResponse.ok().build() );
    }
}
