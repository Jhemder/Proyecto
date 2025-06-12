package com.example.msalmacen.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MaterialUtilizado {
    private String nombre;
    private String tipo;
    private String unidad;
    private Double cantidad;
}
