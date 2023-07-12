package com.atenea.citas.dominio.service;

import com.atenea.citas.models.dto.MedicoDTO;

import java.util.List;

public interface MedicoService {
    MedicoDTO crearMedico(MedicoDTO medicoDTO);
    MedicoDTO obtenerMedico(int tarjetaProfesional);
    void eliminarMedico(int cedula);
    MedicoDTO actualizarMedico(MedicoDTO medicoDTO);
    List<MedicoDTO> obtenerMedicos();
}
