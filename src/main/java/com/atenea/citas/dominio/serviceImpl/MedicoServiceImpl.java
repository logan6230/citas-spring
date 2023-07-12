package com.atenea.citas.dominio.serviceImpl;

import com.atenea.citas.models.dto.MedicoDTO;
import com.atenea.citas.models.entities.Medico;
import com.atenea.citas.models.repository.EspecialidadRepository;
import com.atenea.citas.models.repository.MedicoRepository;
import com.atenea.citas.dominio.service.MedicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public EspecialidadRepository especialidadRepository;

    @Override
    public MedicoDTO crearMedico(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setTarjetaProfesional(medicoDTO.getTarjetaProfesional());
        medico.setNombre(medicoDTO.getNombre());
        medico.setApellido(medicoDTO.getApellido());
        medico.setConsultorio(medicoDTO.getConsultorio());
        medico.setTelefono(medicoDTO.getTelefono());
        medico.setEmail(medicoDTO.getEmail());
        medico.setEspecialidad(medicoDTO.getEspecialidad());
        Medico createdMedico = medicoRepository.save(medico);;
        return modelMapper.map(createdMedico, MedicoDTO.class);
    }


    @Override
    public MedicoDTO obtenerMedico(int tarjetaProfesional) {
        Optional<Medico> medicoOptional = medicoRepository.findById(tarjetaProfesional);
        return medicoOptional.map(medico -> modelMapper.map(medico, MedicoDTO.class)).orElse(null);
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
        Optional<Medico> medicoOptional = medicoRepository.findById(medicoDTO.getTarjetaProfesional());

        if (medicoOptional.isPresent()) {
            Medico medico = medicoOptional.get();
            medico.setTarjetaProfesional(medicoDTO.getTarjetaProfesional());
            medico.setNombre(medicoDTO.getNombre());
            medico.setApellido(medicoDTO.getApellido());
            medico.setConsultorio(medicoDTO.getConsultorio());
            medico.setTelefono(medicoDTO.getTelefono());
            medico.setEmail(medicoDTO.getEmail());
            medico.setEspecialidad(medicoDTO.getEspecialidad());
            // Actualizar otros atributos según sea necesario
            Medico medicoUpdate = medicoRepository.save(medico);

            return modelMapper.map(medicoUpdate, MedicoDTO.class);
        } else {
            return null;
        }

    }

    @Override
    public List<MedicoDTO> obtenerMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(medico -> modelMapper.map(medico, MedicoDTO.class))
                .collect(Collectors.toList());
    }

}

