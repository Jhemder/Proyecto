package com.example.msalmacen.repository;

import com.example.msalmacen.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    Optional<Material> findByNombreAndTipoAndColor(String nombre, String tipo, String color);
}
