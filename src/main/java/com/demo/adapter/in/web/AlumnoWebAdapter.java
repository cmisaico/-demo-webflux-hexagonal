package com.demo.adapter.in.web;

import com.demo.adapter.AlumnoRequest;
import com.demo.application.service.AlumnoUseCase;
import com.demo.common.exceptions.EstadoException;
import com.demo.common.mapper.AlumnoMapper;
import com.demo.domain.Alumno;
import com.demo.domain.Estado;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Validated
@Component
public class AlumnoWebAdapter {

    private static final String BASE_URL = "/api/alumno";
    private final AlumnoUseCase alumnoUseCase;
    private final Validator validator;

    public AlumnoWebAdapter(AlumnoUseCase alumnoUseCase, Validator validator) {
        this.alumnoUseCase = alumnoUseCase;
        this.validator = validator;
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET(BASE_URL.concat("/listar")), this::listar)
                .andRoute(GET(BASE_URL.concat("/listar/{estado}")), this::listarPorEstado)
                .andRoute(POST(BASE_URL.concat("/guardar")), this::guardar)
                .andRoute(PUT(BASE_URL.concat("/actualizar")), this::actualizar)
                .andRoute(DELETE(BASE_URL.concat("/eliminar/{id}")), this::eliminar);
    }

    private Mono<ServerResponse> guardar(
            ServerRequest request) {

        return request.bodyToMono(AlumnoRequest.class)
                .flatMap(alumnoRequest -> {

                    Errors errors = new BeanPropertyBindingResult(alumnoRequest, AlumnoRequest.class.getName());
                    validator.validate(alumnoRequest, errors);

                    if(errors.hasErrors()) {
                        return Flux.fromIterable(errors.getFieldErrors())
                                .map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                                .collectList()
                                .flatMap(list -> ServerResponse.badRequest().body(BodyInserters.fromValue(list)));
                    } else {

                        alumnoUseCase.agregar(AlumnoMapper.INSTANCE.alumnoRequestToAlumno(alumnoRequest));
                        return ServerResponse.status(HttpStatus.CREATED).build();
                    }
                });
    }

    private Mono<ServerResponse> listar(ServerRequest request) {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(alumnoUseCase.listarTodo(), Alumno.class);
    }

    private Mono<ServerResponse> listarPorEstado(ServerRequest request) {
        String estado = request.pathVariable("estado");

        if (!estado.equals(Estado.ACTIVO.toString()) && !estado.equals(Estado.INACTIVO.toString())) {
            return Mono.error(new EstadoException());
        } else {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(alumnoUseCase.listarPorEstado(Estado.valueOf(estado)), Alumno.class);
        }
    }

    private Mono<ServerResponse> actualizar(ServerRequest request) {
        return request.bodyToMono(AlumnoRequest.class)
                .flatMap(alumnoRequest -> {
                    alumnoUseCase.actualizar(AlumnoMapper.INSTANCE.alumnoRequestToAlumno(alumnoRequest));
                    return ServerResponse.status(HttpStatus.CREATED).build();
                });
    }

    private Mono<ServerResponse> eliminar(ServerRequest request) {
        String id = request.pathVariable("id");

        return alumnoUseCase.eliminar(Long.parseLong(id))
                .then(ServerResponse.ok().build());
    }




}
