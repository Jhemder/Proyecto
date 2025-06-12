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
    private String tipo; // Tela, hilo, cremallera, etc.
    private String unidad; // metros, unidades, rollos
    private Double cantidad;
}
