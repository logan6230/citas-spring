package com.atenea.citas.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * Clase que representa un objeto DTO (Data Transfer Object) para un paciente.
 * Contiene información personal básica de un paciente.
 * @Data es una anotación de Lombok que genera getters y setters automáticamente.
 * @ResponseBody es una anotación de Spring que indica que la respuesta de la petición HTTP será un objeto JSON.
 *
 */
@Data
@ResponseBody
public class PacienteDTO {
    private int cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechaNacimiento;

    //No se usan getter y setter ni metodo construtor ya que se utiliza la libreria lombok

    //Crear constructor con todos los parametros
    public PacienteDTO(int cedula, String nombre, String apellido, String telefono, LocalDate fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PacienteDTO(String nombre) {
        this.nombre = nombre;
    }
}

