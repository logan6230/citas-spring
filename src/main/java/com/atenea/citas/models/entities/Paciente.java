package com.atenea.citas.models.entities;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    private int cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    public Paciente(int pacienteId) {
        this.cedula = pacienteId;
    }

    // Constructor, getters y setters
}
