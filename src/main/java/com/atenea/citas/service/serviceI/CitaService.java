package com.atenea.citas.service.serviceI;

import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaPruDTO;

import java.util.List;

public interface CitaService {
    CitaDTO getCitaById(int citaId);
    List<CitaDTO> getAllCitas();
    CitaDTO createCita(CitaDTO citaDTO);
    CitaDTO updateCita(int citaId, CitaDTO citaDTO);
    void deleteCita(int citaId);
    List<CitaPruDTO> obtenerCitas();
}

