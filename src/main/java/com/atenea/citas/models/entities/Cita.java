package com.atenea.citas.models.entities;

import javax.persistence.*;
import java.time.LocalDate;


import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaPruDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;
    private LocalDate fechaCita;

    @ManyToOne
    @JoinColumn(name = "pacienteCedula")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoTarjetaProfesional")
    private Medico medico;

    public Cita(CitaDTO citaDTO) {
        this.idCita = citaDTO.getIdCita();
        this.fechaCita = citaDTO.getFechaCita();
        this.paciente = new Paciente(citaDTO.getPacienteId());
        this.medico = new Medico(citaDTO.getMedicoId());
    }

    public CitaDTO toDTO() {
        return new CitaDTO(idCita, fechaCita, paciente.getCedula(), medico.getTarjetaProfesional());
    }
    public CitaPruDTO toPruDTO() {
        return new CitaPruDTO(idCita, fechaCita, paciente.getNombre(), medico.getNombre());
    }


    // Resto de los getters y setters
}
