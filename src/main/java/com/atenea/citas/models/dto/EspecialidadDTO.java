package com.atenea.citas.models.dto;

import com.atenea.citas.models.entities.Especialidad;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Data
@ResponseBody
public class EspecialidadDTO {
    private Integer idEspecialidad;
    private String nombre;

    // Constructor, getters y setters
    public EspecialidadDTO() {
    }

    public EspecialidadDTO(Integer idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public EspecialidadDTO(Especialidad especialidad) {
        this.idEspecialidad = especialidad.getIdEspecialidad();
        this.nombre = especialidad.getNombre();
    }

    public EspecialidadDTO(String nombre) {
        this.nombre = nombre;
    }
}