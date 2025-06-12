package com.example.msdiseno.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "disenos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diseno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "diseno", cascade = CascadeType.ALL)
    private List<MaterialUsado> materialesUsados;
}
