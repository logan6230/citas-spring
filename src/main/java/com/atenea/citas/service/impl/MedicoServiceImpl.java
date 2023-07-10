package com.atenea.citas.service.impl;

import com.atenea.citas.models.dto.MedicoDTO;
import com.atenea.citas.models.entities.Especialidad;
import com.atenea.citas.models.entities.Medico;
import com.atenea.citas.models.repository.MedicoRepository;
import com.atenea.citas.service.serviceI.MedicoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoDTO crearMedico(MedicoDTO medicoDTO) {
        Medico medico = mapDTOToMedico(medicoDTO);
        Medico medicoGuardado = medicoRepository.save(medico);
        return mapMedicoToDTO(medicoGuardado);
    }

    private Medico mapDTOToMedico(MedicoDTO medicoDTO) {
        return new Medico(
                medicoDTO.getTarjetaProfesional(),
                medicoDTO.getNombre(),
                medicoDTO.getApellido(),
                medicoDTO.getConsultorio(),
                medicoDTO.getTelefono(),
                medicoDTO.getEmail(),
                medicoDTO.getEspecialidad());
    }


    @Override
    public MedicoDTO obtenerMedico(int tarjetaProfesional) {
        Optional<Medico> optionalMedico = medicoRepository.findById(tarjetaProfesional);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            return mapMedicoToDTO(medico);
        } else {
            throw new NoSuchElementException("No se encontró el médico");
        }
    }

    @Override
    public void eliminarMedico(int cedula) {
        Optional<Medico> optionalMedico = medicoRepository.findById(cedula);
        if (optionalMedico.isPresent()) {
            medicoRepository.deleteById(cedula);
        } else {
            throw new NoSuchElementException("No se encontrón el médico");
        }
    }

    @Override
    public MedicoDTO actualizarMedico(MedicoDTO medicoDTO) {
        Medico medico = mapDTOToMedico(medicoDTO);
        Medico medicoGuardado = medicoRepository.save(medico);
        return mapMedicoToDTO(medicoGuardado);
    }

    @Override
    public List<MedicoDTO> obtenerMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return mapMedicosToDTO(medicos);
    }

    //Crear metodo para mapear un medico a medicoDTO
    private List<MedicoDTO> mapMedicosToDTO(List<Medico> medicos) {
        return medicos.stream()
                .map(this::mapMedicoToDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO mapMedicoToDTO(Medico medico) {
        return new MedicoDTO(
                medico.getTarjetaProfesional(),
                medico.getNombre(),
                medico.getApellido(),
                medico.getConsultorio(),
                medico.getTelefono(),
                medico.getEmail(),
                medico.getEspecialidad().getIdEspecialidad());
    }
}

