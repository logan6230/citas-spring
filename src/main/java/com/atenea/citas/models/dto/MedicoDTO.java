package com.atenea.citas.models.dto;

import com.atenea.citas.models.entities.Especialidad;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

//Documenar con javadoc la clase MedicoDTO

/**
 * Clase que representa un objeto DTO (Data Transfer Object) para un paciente.
 * @Data es una anotación de Lombok que genera getters y setters automáticamente.
 * @ResponseBody es una anotación de Spring que indica que la respuesta de la petición HTTP será un objeto JSON.
 *
 */

@Data
@ResponseBody
public class MedicoDTO {
    private int tarjetaProfesional;
    private String nombre;
    private String apellido;
    private String consultorio;
    private String telefono;
    private String email;
    private int especialidad;

    public MedicoDTO(
            int tarjetaProfesional, String nombre, String apellido,
            String consultorio, String telefono,
            String email, int especialidad) {
        this.tarjetaProfesional = tarjetaProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.consultorio = consultorio;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        }

    public MedicoDTO(String nombreMedico) {
        this.nombre = nombreMedico;
    }
}
