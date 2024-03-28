package com.demo.domain;

import lombok.Data;

@Data
public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
