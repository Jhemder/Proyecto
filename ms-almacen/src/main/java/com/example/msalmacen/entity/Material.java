package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="material", uniqueConstraints = @UniqueConstraint(
        columnNames = {"nombre", "tipo", "unidad"}
))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Material {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private String unidad;
    private Double cantidad;
}
