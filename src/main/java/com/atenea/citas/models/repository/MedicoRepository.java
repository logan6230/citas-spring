package com.atenea.citas.models.repository;

import com.atenea.citas.models.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}

