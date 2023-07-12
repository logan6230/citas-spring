package com.atenea.citas.models.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.List;

import com.atenea.citas.models.dto.EspecialidadDTO;
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
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tarjetaProfesional;
    private String nombre;
    private String apellido;
    private String consultorio;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    public Medico(int medicoId) {
        this.tarjetaProfesional = medicoId;
    }

    public Medico(int tarjetaProfesional, String nombre, String apellido, String consultorio, String telefono, String email, EspecialidadDTO especialidad) {
        this.tarjetaProfesional = tarjetaProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.consultorio = consultorio;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = new Especialidad(especialidad.getIdEspecialidad());
    }

    // Constructor, getters y setters
}
