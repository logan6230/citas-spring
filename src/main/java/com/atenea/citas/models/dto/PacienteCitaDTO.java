package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class PacienteCitaDTO {
private String nombre;

    public PacienteCitaDTO(String nombrePaciente) {
        this.nombre = nombrePaciente;
    }
}
