package com.example.msalmacen.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialRequestDTO {
    private String nombre;
    private String tipo;
    private String color;
    private String unidadMedida;
    private Double cantidad;
    private Double costoUnitario;
    private String proveedor;
}
