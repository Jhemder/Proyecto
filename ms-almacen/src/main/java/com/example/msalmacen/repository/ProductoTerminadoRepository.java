package com.example.msalmacen.repository;

import com.example.msalmacen.entity.ProductoTerminado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductoTerminadoRepository extends JpaRepository<ProductoTerminado, Long> {
    Optional<ProductoTerminado> findByNombreAndFechaFabricacion(String nombre, LocalDate fecha);
    List<ProductoTerminado> findByFechaFabricacionBetween(LocalDate start, LocalDate end);
}
