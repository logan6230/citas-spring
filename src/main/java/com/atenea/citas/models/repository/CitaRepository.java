package com.atenea.citas.models.repository;

import com.atenea.citas.models.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
