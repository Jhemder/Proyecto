package com.example.msdiseno.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materiales_usados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialUsado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idMaterial;

    private Double cantidadNecesaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diseno_id")
    private Diseno diseno;
}
