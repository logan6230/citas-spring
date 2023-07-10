package com.atenea.citas.service.impl;
import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaPruDTO;
import com.atenea.citas.models.entities.Cita;
import com.atenea.citas.models.repository.CitaRepository;
import com.atenea.citas.service.serviceI.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public CitaDTO getCitaById(int citaId) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita not found with id: " + citaId));
        return cita.toDTO();
    }

    @Override
    public List<CitaDTO> getAllCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream()
                .map(Cita::toDTO)
                .collect(Collectors.toList());
    }

   @Override
    public List<CitaPruDTO> obtenerCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream()
                .map(cita -> {
                    CitaPruDTO citaPruDTO = cita.toPruDTO();
                    citaPruDTO.getPaciente().setNombre(cita.getPaciente().getNombre());
                    citaPruDTO.getMedico().setNombre(cita.getMedico().getNombre());
                    citaPruDTO.getMedico().getEspecialidad().setNombre(cita.getMedico().getEspecialidad().getNombre());
                    return citaPruDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CitaDTO createCita(CitaDTO citaDTO) {
        Cita cita = new Cita(citaDTO);
        Cita savedCita = citaRepository.save(cita);
        return savedCita.toDTO();
    }

    @Override
    public CitaDTO updateCita(int citaId, CitaDTO citaDTO) {
        Cita existingCita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita not found with id: " + citaId));

        existingCita.setFechaCita(citaDTO.getFechaCita());

        Cita updatedCita = citaRepository.save(existingCita);
        return updatedCita.toDTO();
    }

    @Override
    public void deleteCita(int citaId) {
        citaRepository.deleteById(citaId);
    }
}

