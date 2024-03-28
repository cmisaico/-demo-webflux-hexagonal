package com.demo.adapter.out.persistence.repository;

import com.demo.adapter.out.persistence.entity.AlumnoEntidad;
import com.demo.domain.Estado;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AlumnoRepository extends ReactiveCrudRepository<AlumnoEntidad, Long> {


    Flux<AlumnoEntidad> findByEstado(Estado estado);
}
