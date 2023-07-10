package com.atenea.citas.web.controller;

import com.atenea.citas.exceptions.PacienteNotFoundException;
import com.atenea.citas.models.dto.PacienteDTO;
import com.atenea.citas.service.serviceI.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteController {
    @Autowired
    private  PacienteService pacienteService;

    /*
    //Esta es otra manera de hacer inyeccion de dependencias sin usar @awtowired

    private final PacienteRepository pacienteRepository;
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }*/

    @GetMapping("/pacientes" )
    public List<PacienteDTO> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    @GetMapping("/paciente/{pacienteID}")
    public PacienteDTO obtenerPaciente(@PathVariable("pacienteID") int pacienteID) {

        PacienteDTO pacienteDTO = pacienteService.obtenerPaciente(pacienteID);

        if (pacienteDTO == null) {
            throw new PacienteNotFoundException("Paciente no encontrado"); // Lanzar una excepción personalizada
        }
        return pacienteDTO;
    }

    @PostMapping("/paciente")
    public PacienteDTO crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.crearPaciente(pacienteDTO);
    }

    @PutMapping("/paciente")
    public PacienteDTO actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO pacienteDto = pacienteService.obtenerPaciente(pacienteDTO.getCedula());
        if (pacienteDto == null) {
            throw new PacienteNotFoundException("Paciente no encontrado"); // Lanzar una excepción personalizada
        }
        return pacienteService.actualizarPaciente(pacienteDTO);
    }

    @DeleteMapping("/paciente/{pacienteID}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable("pacienteID") int pacienteID) {
        try {
            pacienteService.eliminarPaciente(pacienteID);
            return ResponseEntity.noContent().build();
        } catch (PacienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
