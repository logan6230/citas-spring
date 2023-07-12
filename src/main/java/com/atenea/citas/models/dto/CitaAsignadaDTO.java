package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
@Data
@ResponseBody
public class CitaAsignadaDTO {
    private int idCita;
    private LocalDate fechaCita;
    private PacienteCitaDTO paciente;
    private MedicoCitaDTO medico;

    public CitaAsignadaDTO(int idCita, LocalDate fechaCita, String nombrePaciente, String nombreMedico) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.paciente = new PacienteCitaDTO(nombrePaciente);
        this.medico = new MedicoCitaDTO(nombreMedico);


    }

    // Constructor, getters y setters
}

