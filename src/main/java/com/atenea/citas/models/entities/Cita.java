package com.atenea.citas.models.entities;

import javax.persistence.*;
import java.time.LocalDate;


import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaAsignadaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

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
        this.paciente = new Paciente(citaDTO.getPacienteCedula());
        this.medico = new Medico(citaDTO.getMedicoTarjetaProfesional());
    }

    public CitaDTO toDTO() {
        return new CitaDTO(idCita, fechaCita, paciente.getCedula(), medico.getTarjetaProfesional());
    }
    public CitaAsignadaDTO toPruDTO() {
        return new CitaAsignadaDTO(idCita, fechaCita, paciente.getNombre(), medico.getNombre());
    }

    public void setMedico(int medicoTarjetaProfesional) {
        this.medico = new Medico(medicoTarjetaProfesional);
    }

    public void setPaciente(int pacienteCedula) {
        this.paciente = new Paciente(pacienteCedula);
    }


    // Resto de los getters y setters
}
