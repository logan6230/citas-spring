package com.atenea.citas.models.entities;

import javax.persistence.*;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;
    private String nombre;

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;

    public Especialidad(int especialidad) {
        this.idEspecialidad = especialidad;
    }


    // Constructor, getters y setters
}
