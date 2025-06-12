package com.example.msdiseno.dto;

public class DescuentoMaterialDTO {

    private Long idMaterial;
    private Double cantidad;

    // Constructor vacío
    public DescuentoMaterialDTO() {
    }

    // Constructor con parámetros
    public DescuentoMaterialDTO(Long idMaterial, Double cantidad) {
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
