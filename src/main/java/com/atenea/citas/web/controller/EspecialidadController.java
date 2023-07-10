package com.atenea.citas.web.controller;

import com.atenea.citas.models.dto.EspecialidadDTO;
import com.atenea.citas.service.serviceI.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EspecialidadController {
    private final EspecialidadService especialidadService;

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping("/especialidades")
    public ResponseEntity<List<EspecialidadDTO>> getAllEspecialidades() {
        List<EspecialidadDTO> especialidades = especialidadService.getAllEspecialidades();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/especialidad/{id}")
    public ResponseEntity<EspecialidadDTO> getEspecialidadById(@PathVariable int id) {
        EspecialidadDTO especialidad = especialidadService.getEspecialidadById(id);
        if (especialidad != null) {
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/especialidad")
    public ResponseEntity<EspecialidadDTO> createEspecialidad(@RequestBody String especialidad) {
        EspecialidadDTO createdEspecialidad = especialidadService.createEspecialidad(especialidad);
        return new ResponseEntity<>(createdEspecialidad, HttpStatus.CREATED);
    }

    @PutMapping("/especialidad/{id}")
    public ResponseEntity<EspecialidadDTO> updateEspecialidad(@PathVariable int id, @RequestBody EspecialidadDTO especialidadDTO) {
        EspecialidadDTO updatedEspecialidad = especialidadService.updateEspecialidad(id, especialidadDTO);
        if (updatedEspecialidad != null) {
            return new ResponseEntity<>(updatedEspecialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/especialidad/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable int id) {
        boolean deleted = especialidadService.deleteEspecialidad(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

