package com.demo.adapter;

import com.demo.domain.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AlumnoResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
