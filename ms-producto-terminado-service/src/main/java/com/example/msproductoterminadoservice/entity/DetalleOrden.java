package com.example.msproductoterminadoservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreMaterial;
    private String unidad;
    private Double cantidadUtilizada;

    @ManyToOne
    @JoinColumn(name = "orden_fabricacion_id")
    private OrdenFabricacion ordenFabricacion;
}
