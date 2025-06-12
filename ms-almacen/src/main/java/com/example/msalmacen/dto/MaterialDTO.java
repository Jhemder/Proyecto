package com.example.msalmacen.dto;

import lombok.Data;

@Data
public class MaterialDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private Integer stock;
}

