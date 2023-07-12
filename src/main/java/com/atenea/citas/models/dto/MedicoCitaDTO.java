package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class MedicoCitaDTO {
    private String nombre;
    private EspecialidadCitaDTO especialidad;

    public MedicoCitaDTO(String nombreMedico) {
        this.nombre = nombreMedico;
    }

    public void setEspecialidad(String nombre) {
        this.especialidad = new EspecialidadCitaDTO(nombre);
    }
}
