package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // Ej: tela, hilo
    private String unidadMedida; // Ej: metros, unidades
    private Double cantidad; // Stock disponible
}
