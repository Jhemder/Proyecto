package com.example.msalmacen.repository;

import com.example.msalmacen.entity.ProductoTerminado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoTerminadoRepository extends JpaRepository<ProductoTerminado, Long> {
    Optional<ProductoTerminado> findByNombreIgnoreCaseAndCategoriaIgnoreCaseAndUnidadIgnoreCase(String nombre, String categoria, String unidad);
}
