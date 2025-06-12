package com.example.msalmacen.repository;

import com.example.msalmacen.entity.ProductoTerminado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoTerminadoRepository extends JpaRepository<ProductoTerminado, Long> {
}
