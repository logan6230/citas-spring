package com.atenea.citas.exceptions;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String mensaje) {
        super(mensaje);
    }
}
