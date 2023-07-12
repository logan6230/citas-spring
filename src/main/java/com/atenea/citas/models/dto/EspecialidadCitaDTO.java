package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class EspecialidadCitaDTO {
    private String nombre;

    public EspecialidadCitaDTO(String nombre) {
        this.nombre = nombre;
    }
}
