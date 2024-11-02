package com.erikhdezv.crud_reactivo.controller;

import com.erikhdezv.crud_reactivo.controller.handler.PersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class PersonRoute {

    private static final String PERSON = "/person";
    private static final String PERSON_PARAM = "/person/{id}";

    @Bean
    public RouterFunction<ServerResponse> personRoutes(PersonHandler personHandler) {
        return route( GET(PERSON), personHandler::allPerson )
                .andRoute( GET(PERSON_PARAM), personHandler::personById)
                .andRoute( POST(PERSON), personHandler::savePerson)
                .andRoute( PUT(PERSON_PARAM), personHandler::updatePerson)
                .andRoute( DELETE(PERSON_PARAM), personHandler::deletePerson);
    }
}
