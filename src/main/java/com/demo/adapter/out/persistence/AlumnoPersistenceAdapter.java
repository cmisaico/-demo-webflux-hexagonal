package com.demo.adapter.out.persistence;

import com.demo.adapter.out.persistence.repository.AlumnoRepository;
import com.demo.application.port.out.AlumnoOutputPort;
import com.demo.common.mapper.AlumnoMapper;
import com.demo.domain.Alumno;
import com.demo.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AlumnoPersistenceAdapter implements AlumnoOutputPort {

    private final AlumnoRepository alumnoRepository;

    public AlumnoPersistenceAdapter(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Mono<Void> agregar(Alumno alumno) {
        return alumnoRepository.save(AlumnoMapper.INSTANCE.alumnoToAlumnoEntidad(alumno))
                .thenEmpty(Mono.empty())    ;
    }

    @Override
    public Flux<Alumno> listarTodo() {
        return alumnoRepository.findAll()
                .map(AlumnoMapper.INSTANCE::alumnoEntidadToAlumno);
    }

    @Override
    public Flux<Alumno> listarPorEstado(Estado estado) {
        return alumnoRepository.findByEstado(estado)
                .map(AlumnoMapper.INSTANCE::alumnoEntidadToAlumno);
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return alumnoRepository.deleteById(id)
                .then();
    }

    @Override
    public Mono<Void> actualizar(Alumno alumno) {
        return alumnoRepository.findById(alumno.getId())
                .doOnNext(alumnoEntidad -> AlumnoMapper.INSTANCE.alumnoToAlumnoEntidad(alumno))
                .map(alumnoRepository::save)
                .then();
    }
}
