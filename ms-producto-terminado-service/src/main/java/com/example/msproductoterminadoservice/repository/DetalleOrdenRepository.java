package com.example.msproductoterminadoservice.repository;

import com.example.msproductoterminadoservice.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
}
