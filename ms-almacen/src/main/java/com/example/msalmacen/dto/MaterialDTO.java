package com.example.msalmacen.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialDTO {
    private String nombre;
    private String tipo;            // Ej: tela, hilo, botón
    private String unidadMedida;    // Ej: metros, unidades
    private Double cantidad;        // Cantidad a ingresar o sumar
}
