package com.example.msalmacenservice.repository;

import com.example.msalmacenservice.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    // Aquí podrías agregar métodos personalizados si lo necesitas, por ejemplo:
    // List<Material> findByTipoMaterial(String tipoMaterial);
}
