package com.atenea.citas.service.impl;


import com.atenea.citas.models.dto.EspecialidadDTO;
import com.atenea.citas.models.entities.Especialidad;
import com.atenea.citas.models.repository.EspecialidadRepository;
import com.atenea.citas.service.serviceI.EspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    private final EspecialidadRepository especialidadRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, ModelMapper modelMapper) {
        this.especialidadRepository = especialidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EspecialidadDTO> getAllEspecialidades() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        return especialidades.stream()
                .map(especialidad -> modelMapper.map(especialidad, EspecialidadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EspecialidadDTO getEspecialidadById(int id) {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(id);
        return especialidadOptional.map(especialidad -> modelMapper.map(especialidad, EspecialidadDTO.class)).orElse(null);
    }

    @Override
    public EspecialidadDTO createEspecialidad(String nameEspecialida) {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(nameEspecialida);
        Especialidad createdEspecialidad = especialidadRepository.save(especialidad);
        return modelMapper.map(createdEspecialidad, EspecialidadDTO.class);
    }

    @Override
    public EspecialidadDTO updateEspecialidad(int id, EspecialidadDTO especialidadDTO) {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(id);
        if (especialidadOptional.isPresent()) {
            Especialidad especialidad = especialidadOptional.get();
            especialidad.setNombre(especialidadDTO.getNombre());
            // Actualizar otros atributos según sea necesario
            Especialidad updatedEspecialidad = especialidadRepository.save(especialidad);
            return modelMapper.map(updatedEspecialidad, EspecialidadDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteEspecialidad(int id) {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(id);
        if (especialidadOptional.isPresent()) {
            especialidadRepository.delete(especialidadOptional.get());
            return true;
        } else {
            return false;
        }
    }
}

