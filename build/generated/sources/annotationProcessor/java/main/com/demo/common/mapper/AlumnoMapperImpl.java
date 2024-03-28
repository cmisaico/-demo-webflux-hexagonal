package com.demo.common.mapper;

import com.demo.adapter.AlumnoRequest;
import com.demo.adapter.AlumnoResponse;
import com.demo.adapter.AlumnoResponse.AlumnoResponseBuilder;
import com.demo.adapter.out.persistence.entity.AlumnoEntidad;
import com.demo.adapter.out.persistence.entity.AlumnoEntidad.AlumnoEntidadBuilder;
import com.demo.domain.Alumno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T13:17:30-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 11.0.22 (Amazon.com Inc.)"
)
@Component
public class AlumnoMapperImpl implements AlumnoMapper {

    @Override
    public Alumno alumnoRequestToAlumno(AlumnoRequest alumnoRequest) {
        if ( alumnoRequest == null ) {
            return null;
        }

        Alumno alumno = new Alumno();

        alumno.setId( alumnoRequest.getId() );
        alumno.setNombre( alumnoRequest.getNombre() );
        alumno.setApellido( alumnoRequest.getApellido() );
        alumno.setEstado( alumnoRequest.getEstado() );
        alumno.setEdad( alumnoRequest.getEdad() );

        return alumno;
    }

    @Override
    public AlumnoEntidad alumnoToAlumnoEntidad(Alumno alumno) {
        if ( alumno == null ) {
            return null;
        }

        AlumnoEntidadBuilder alumnoEntidad = AlumnoEntidad.builder();

        alumnoEntidad.id( alumno.getId() );
        alumnoEntidad.nombre( alumno.getNombre() );
        alumnoEntidad.apellido( alumno.getApellido() );
        alumnoEntidad.estado( alumno.getEstado() );
        alumnoEntidad.edad( alumno.getEdad() );

        return alumnoEntidad.build();
    }

    @Override
    public Alumno alumnoEntidadToAlumno(AlumnoEntidad alumnoEntidad) {
        if ( alumnoEntidad == null ) {
            return null;
        }

        Alumno alumno = new Alumno();

        alumno.setId( alumnoEntidad.getId() );
        alumno.setNombre( alumnoEntidad.getNombre() );
        alumno.setApellido( alumnoEntidad.getApellido() );
        alumno.setEstado( alumnoEntidad.getEstado() );
        alumno.setEdad( alumnoEntidad.getEdad() );

        return alumno;
    }

    @Override
    public AlumnoResponse alumnoToAlumnoResponse(AlumnoEntidad alumnoEntidad) {
        if ( alumnoEntidad == null ) {
            return null;
        }

        AlumnoResponseBuilder alumnoResponse = AlumnoResponse.builder();

        alumnoResponse.id( alumnoEntidad.getId() );
        alumnoResponse.nombre( alumnoEntidad.getNombre() );
        alumnoResponse.apellido( alumnoEntidad.getApellido() );
        alumnoResponse.estado( alumnoEntidad.getEstado() );
        alumnoResponse.edad( alumnoEntidad.getEdad() );

        return alumnoResponse.build();
    }
}
