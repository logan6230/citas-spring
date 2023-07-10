package com.atenea.citas.models.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
@Data
@ResponseBody
public class CitaPruDTO {
    private int idCita;
    private LocalDate fechaCita;
    private PacienteDTO paciente;
    private MedicoDTO medico;

    public CitaPruDTO(int idCita, LocalDate fechaCita, String nombrePaciente, String nombreMedico) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.paciente = new PacienteDTO(nombrePaciente);
        this.medico = new MedicoDTO(nombreMedico);


    }

    // Constructor, getters y setters
}

