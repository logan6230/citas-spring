package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Data
@ResponseBody
public class CitaDTO {
    private int idCita;
    private LocalDate fechaCita;
    private int pacienteId;
    private int medicoId;

    public CitaDTO(int idCita, LocalDate fechaCita, int pacienteId, int medicoId) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }
    // Constructor, getters y setters
}
