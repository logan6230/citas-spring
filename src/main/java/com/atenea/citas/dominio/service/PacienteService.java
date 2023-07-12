package com.atenea.citas.dominio.service;

import com.atenea.citas.models.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {
    List<PacienteDTO> obtenerPacientes();
    PacienteDTO crearPaciente(PacienteDTO pacienteDTO);

    PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO);

    PacienteDTO obtenerPaciente(int cedula);

    void eliminarPaciente(int cedula);
}
