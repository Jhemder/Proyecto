package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materiales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // ejemplo: Tela, Cremallera

    private String tipo; // ejemplo: Algodón, Nailon

    private String color;

    private String unidadMedida; // metros, unidades, rollos, etc

    private Double cantidad; // cantidad total disponible

    private Double costoUnitario;

    private String proveedor;
}
