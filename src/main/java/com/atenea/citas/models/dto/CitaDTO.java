package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Data
@ResponseBody
public class CitaDTO {
    private int idCita;
    private LocalDate fechaCita;
    private int pacienteCedula;
    private int medicoTarjetaProfesional;

    public CitaDTO(int idCita, LocalDate fechaCita, int pacienteCedula, int medicoTarjetaProfesional) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.pacienteCedula = pacienteCedula;
        this.medicoTarjetaProfesional = medicoTarjetaProfesional;
    }
    // Constructor, getters y setters
}
