package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="producto_terminado", uniqueConstraints = @UniqueConstraint(
        columnNames = {"nombre", "fechaFabricacion"}
))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoTerminado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaFabricacion;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<MaterialUtilizado> materialesUtilizados;
    private Integer cantidadFabricada;  // total cantidad de este producto
}
