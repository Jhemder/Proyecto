package com.example.msproductoterminadoservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class OrdenFabricacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoPrenda;
    private int cantidad;
    private LocalDate fechaFabricacion;

    @OneToMany(mappedBy = "ordenFabricacion", cascade = CascadeType.ALL)
    private List<DetalleOrden> detalles;
}
