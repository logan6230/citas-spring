package com.atenea.citas.web.controller;

import com.atenea.citas.models.dto.MedicoDTO;
import com.atenea.citas.dominio.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class MedicosController {

    private final MedicoService medicoService;

    @Autowired
    public MedicosController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<MedicoDTO>> obtenerMedicos() {
        try {
            List<MedicoDTO> medicos = medicoService.obtenerMedicos();
            return ResponseEntity.ok().body(medicos);
        } catch (Exception e) {
            // Manejo de excepciones adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/medico/{tarjetaProfesional}")
    public ResponseEntity<MedicoDTO> obtenerMedico(@PathVariable("tarjetaProfesional") int tarjetaProfesional) {
        try {
            MedicoDTO medico = medicoService.obtenerMedico(tarjetaProfesional);
            return ResponseEntity.ok().body(medico);
        } catch (Exception e) {
            // Manejo de excepciones adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/medico")
    public ResponseEntity<MedicoDTO> crearMedico(@RequestBody MedicoDTO medicoDTO) {
        try {
            MedicoDTO medico = medicoService.crearMedico(medicoDTO);
            return ResponseEntity.ok().body(medico);
        } catch (Exception e) {
            // Manejo de excepciones adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/medico")
    public ResponseEntity<MedicoDTO> actualizarMedico(@RequestBody MedicoDTO medicoDTO) {
        System.out.println("controller" + medicoDTO);
        try {
            MedicoDTO medico = medicoService.actualizarMedico(medicoDTO);
            return ResponseEntity.ok().body(medico);
        } catch (Exception e) {
            // Manejo de excepciones adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/medico/{tarjetaProfesional}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable("tarjetaProfesional") int tarjetaProfesional) {
        try {
            medicoService.eliminarMedico(tarjetaProfesional);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            // Manejo de excepciones adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
