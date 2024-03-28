package com.demo.application.port.out;

import com.demo.domain.Alumno;
import com.demo.domain.Estado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoOutputPort {
    public Mono<Void> agregar(Alumno alumno);
    public Flux<Alumno> listarTodo();

    public Flux<Alumno> listarPorEstado(Estado estado);

    public Mono<Void> eliminar(Long id);

    public Mono<Void> actualizar(Alumno alumno);
}
