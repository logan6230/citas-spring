package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Data
@ResponseBody
public class EspecialidadDTO {
    private int idEspecialidad;
    private String nombre;

    // Constructor, getters y setters
    public EspecialidadDTO() {
    }

    public EspecialidadDTO(int idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }
}