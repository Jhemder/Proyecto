package com.example.msalmacen.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialUsoDTO {
    private Long materialId;       // ID del material
    private Double cantidadUsada;  // Cuánto se usa en este producto
}
