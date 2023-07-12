package com.atenea.citas.models.repository;

import com.atenea.citas.models.dto.EspecialidadDTO;
import com.atenea.citas.models.entities.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    EspecialidadDTO findByIdEspecialidad(EspecialidadDTO especialidad);

    // Aquí puedes agregar métodos personalizados si es necesario
}
