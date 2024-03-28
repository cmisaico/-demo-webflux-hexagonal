package com.demo.common.mapper;

import com.demo.adapter.AlumnoRequest;
import com.demo.adapter.AlumnoResponse;
import com.demo.adapter.out.persistence.entity.AlumnoEntidad;
import com.demo.domain.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    //    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Alumno alumnoRequestToAlumno(AlumnoRequest alumnoRequest);

    AlumnoEntidad alumnoToAlumnoEntidad(Alumno alumno);

    Alumno alumnoEntidadToAlumno(AlumnoEntidad alumnoEntidad);

    AlumnoResponse alumnoToAlumnoResponse(AlumnoEntidad alumnoEntidad);

//    AlumnoResponse alumnoEntidadToAlumnoResponse(AlumnoEntidad alumnoEntidad);
//
//    void updateAlumno(AlumnoRequest alumnoRequest, @MappingTarget AlumnoEntidad alumnoEntidad);

}
