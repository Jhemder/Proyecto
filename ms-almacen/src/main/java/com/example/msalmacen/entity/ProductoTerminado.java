package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductoTerminado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private String unidad;
    private int cantidad;

    // Opcional: para luego filtrar por fecha de creación
    private String fechaRegistro;
}
