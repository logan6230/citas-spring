package com.atenea.citas.dominio.serviceImpl;

import com.atenea.citas.models.dto.PacienteDTO;
import com.atenea.citas.models.entities.Paciente;
import com.atenea.citas.models.repository.PacienteRepository;
import com.atenea.citas.dominio.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//Documentar la clase PacienteServiceImpl con javaDoc

/**
 * La clase PacienteServiceImpl implementa la interfaz PacienteService.
 * @Service indica que la clase es un servicio y que se puede inyectar en otros componentes.
 * @Date 2023-07-09
 */
@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    /**
     * Método que crea un objeto Paciente a partir de un objeto PacienteDTO y lo guarda en la base de datos.
     * @param pacienteDTO
     * @return PacienteDTO
     */
    @Override
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setCedula(pacienteDTO.getCedula());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setTelefono(pacienteDTO.getTelefono());

        Paciente pacienteCreado = pacienteRepository.save(paciente);
        return mapPacienteToDTO(pacienteCreado);
    }

    @Override
    public List<PacienteDTO> obtenerPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return mapPacientesToDTO(pacientes);
    }

    /**
     * Método que actualiza un objeto Paciente a partir de un objeto PacienteDTO y lo guarda en la base de datos.
     * @param pacienteDTO
     * @return PacienteDTO
     */
    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();

        paciente.setCedula(pacienteDTO.getCedula());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setTelefono(pacienteDTO.getTelefono());

        Paciente pacienteActualizado = pacienteRepository.save(paciente);
        return mapPacienteToDTO(pacienteActualizado);
    }

    @Override
    public PacienteDTO obtenerPaciente(int id) {
        return pacienteRepository.findById(id).map(this::mapPacienteToDTO).orElse(null);
    }


    @Override
    public void eliminarPaciente(int id) {
        pacienteRepository.deleteById(id);
    }

    /**
     * Método que mapea una lista de objetos Paciente a una lista de objetos PacienteDTO.
     * @param pacientes
     * @return List<PacienteDTO>
     */
    private List<PacienteDTO> mapPacientesToDTO(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::mapPacienteToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método que mapea un objeto Paciente a un objeto PacienteDTO.
     * @param paciente
     * @return PacienteDTO
     */
    private PacienteDTO mapPacienteToDTO(Paciente paciente) {
        return new PacienteDTO(paciente.getCedula(), paciente.getNombre(), paciente.getApellido(), paciente.getTelefono(),paciente.getFechaNacimiento());
    }
}

