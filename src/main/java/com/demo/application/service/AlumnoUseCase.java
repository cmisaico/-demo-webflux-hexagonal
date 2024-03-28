package com.demo.application.service;


import com.demo.application.port.in.AlumnoInputPort;
import com.demo.application.port.out.AlumnoOutputPort;
import com.demo.domain.Alumno;
import com.demo.domain.Estado;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AlumnoUseCase implements AlumnoInputPort {

    private final AlumnoOutputPort alumnoOutputPort;

    public AlumnoUseCase(AlumnoOutputPort alumnoOutputPort) {
        this.alumnoOutputPort = alumnoOutputPort;
    }

    @Override
    public Mono<Void> agregar(Alumno alumno) {
        return alumnoOutputPort.agregar(alumno);
    }

    @Override
    public Flux<Alumno> listarTodo() {
        return alumnoOutputPort.listarTodo();
    }

    @Override
    public Flux<Alumno> listarPorEstado(Estado estado) {
        return alumnoOutputPort.listarPorEstado(estado);
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return alumnoOutputPort.eliminar(id);
    }

    @Override
    public Mono<Void> actualizar(Alumno alumno) {
        return alumnoOutputPort.actualizar(alumno);
    }
}
