package com.demo.common.exceptions;

public class EstadoException extends RuntimeException{

    @Override
    public String getMessage() {
        return "El estado no es válido";
    }
}
