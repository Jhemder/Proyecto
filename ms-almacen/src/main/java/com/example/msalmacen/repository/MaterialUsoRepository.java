package com.example.msalmacen.repository;

import com.example.msalmacen.entity.MaterialUso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialUsoRepository extends JpaRepository<MaterialUso, Long> {
    List<MaterialUso> findByProductoId(Long productoId);
}
