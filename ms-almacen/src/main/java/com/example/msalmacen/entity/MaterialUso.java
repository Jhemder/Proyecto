package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoTerminado producto;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private Double cantidadUsada;
}
