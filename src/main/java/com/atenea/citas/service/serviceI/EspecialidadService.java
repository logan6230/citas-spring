package com.atenea.citas.service.serviceI;

import com.atenea.citas.models.dto.EspecialidadDTO;

import java.util.List;

public interface EspecialidadService {
    List<EspecialidadDTO> getAllEspecialidades();
    EspecialidadDTO getEspecialidadById(int id);
    EspecialidadDTO createEspecialidad(String especialidad);
    EspecialidadDTO updateEspecialidad(int id, EspecialidadDTO especialidadDTO);
    boolean deleteEspecialidad(int id);
}
