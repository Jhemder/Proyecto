package com.example.msalmacen.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class MaterialUtilizado {
    private String nombre;      // "Tela Lycra"
    private Double cantidad;    // 2.0
}
