package com.demo.adapter.out.persistence.entity;

import com.demo.domain.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table("ALUMNO_ENTIDAD")
public class AlumnoEntidad {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
