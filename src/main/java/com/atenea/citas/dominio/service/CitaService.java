package com.atenea.citas.dominio.service;

import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaAsignadaDTO;

import java.util.List;

public interface CitaService {
    CitaDTO getCitaById(int citaId);
    List<CitaDTO> getAllCitas();
    CitaDTO createCita(CitaDTO citaDTO);
    CitaDTO updateCita(CitaDTO citaDTO);
    void deleteCita(int citaId);
    List<CitaAsignadaDTO> obtenerCitas();
}

