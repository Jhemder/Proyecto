package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materiales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;

    @Column(length = 50, nullable = false)
    private String nombreMaterial;

    @Column(length = 50)
    private String tipoMaterial;

    @Column(length = 255)
    private String composicion;

    @Column(columnDefinition = "TEXT")
    private String propiedadesClave;

    @Column(columnDefinition = "TEXT")
    private String usosComunes;

    private Boolean requiereMezcla;

    @Column(length = 255)
    private String proveedoresSugeridos;

    @Column(precision = 10, scale = 2)
    private Double costoUnitarioAprox;

    @Column(length = 20)
    private String unidadMedida;

    private Double stockDisponible; // NUEVO: Cantidad disponible en almacén (en la unidad definida)
}
