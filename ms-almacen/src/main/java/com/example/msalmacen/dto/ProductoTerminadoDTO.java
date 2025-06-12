package com.example.msalmacen.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoTerminadoDTO {
    private String nombre;                          // Ej: Polo deportivo
    private String descripcion;                     // Ej: Polo de entrenamiento color negro
    private List<MaterialUsoDTO> materialesUsados;  // Lista de materiales usados en este producto
}
