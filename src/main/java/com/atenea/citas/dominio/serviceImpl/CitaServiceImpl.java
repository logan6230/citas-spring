package com.atenea.citas.dominio.serviceImpl;
import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaAsignadaDTO;
import com.atenea.citas.models.entities.Cita;
import com.atenea.citas.models.repository.CitaRepository;
import com.atenea.citas.dominio.service.CitaService;
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
    public List<CitaAsignadaDTO> obtenerCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream()
                .map(cita -> {
                    CitaAsignadaDTO citaAsignadaDTO = cita.toPruDTO();
                    citaAsignadaDTO.getPaciente().setNombre(cita.getPaciente().getNombre());
                    citaAsignadaDTO.getMedico().setNombre(cita.getMedico().getNombre());
                    citaAsignadaDTO.getMedico().setEspecialidad(cita.getMedico().getEspecialidad().getNombre());
                    return citaAsignadaDTO;
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
    public CitaDTO updateCita(CitaDTO citaDTO) {
        Cita existingCita = citaRepository.findById(citaDTO.getIdCita())
                .orElseThrow(() -> new RuntimeException("Cita not found with id: " + citaDTO.getIdCita()));
        existingCita.setIdCita(citaDTO.getIdCita());
        existingCita.setFechaCita(citaDTO.getFechaCita());
        existingCita.setMedico(citaDTO.getMedicoTarjetaProfesional());
        existingCita.setPaciente(citaDTO.getPacienteCedula());

        Cita updatedCita = citaRepository.save(existingCita);
        return updatedCita.toDTO();
    }

    @Override
    public void deleteCita(int citaId) {
        citaRepository.deleteById(citaId);
    }
}

