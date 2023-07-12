package com.atenea.citas.web.controller;

import com.atenea.citas.models.dto.CitaDTO;
import com.atenea.citas.models.dto.CitaAsignadaDTO;
import com.atenea.citas.dominio.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/cita/{citaId}")
    public ResponseEntity<CitaDTO> getCitaById(@PathVariable int citaId) {
        CitaDTO citaDTO = citaService.getCitaById(citaId);
        return new ResponseEntity<>(citaDTO, HttpStatus.OK);
    }

    @GetMapping("/obtener-citas")
    public ResponseEntity<List<CitaDTO>> getAllCitas() {
        List<CitaDTO> citas = citaService.getAllCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PostMapping("/cita")
    public ResponseEntity<CitaDTO> createCita(@RequestBody CitaDTO citaDTO) {
        CitaDTO createdCita = citaService.createCita(citaDTO);
        return new ResponseEntity<>(createdCita, HttpStatus.CREATED);
    }

    @PutMapping("/cita")
    public ResponseEntity<CitaDTO> updateCita( @RequestBody CitaDTO citaDTO) {
        CitaDTO updatedCita = citaService.updateCita(citaDTO);
        return new ResponseEntity<>(updatedCita, HttpStatus.OK);

    }

    @DeleteMapping("/cita/{citaId}")
    public ResponseEntity<Void> deleteCita(@PathVariable int citaId) {
        citaService.deleteCita(citaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/citas")
    public ResponseEntity<List<CitaAsignadaDTO>> obtenerCitas() {
        List<CitaAsignadaDTO> citas = citaService.obtenerCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}

