package com.example.msalmacenservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materiales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long id;

    @Column(name = "nombre_material", length = 50, nullable = false)
    private String nombreMaterial;

    @Column(name = "tipo_material", length = 50)
    private String tipoMaterial;

    @Column(name = "composicion", length = 255)
    private String composicion;

    @Column(name = "propiedades_clave", columnDefinition = "TEXT")
    private String propiedadesClave;

    @Column(name = "usos_comunes", columnDefinition = "TEXT")
    private String usosComunes;

    @Column(name = "requiere_mezcla")
    private Boolean requiereMezcla;

    @Column(name = "proveedores_sugeridos", length = 255)
    private String proveedoresSugeridos;

    @Column(name = "costo_unitario_aprox", precision = 10, scale = 2)
    private Double costoUnitarioAprox;

    @Column(name = "unidad_medida", length = 20)
    private String unidadMedida;

    @Column(name = "notas_adicionales", columnDefinition = "TEXT")
    private String notasAdicionales;
}
