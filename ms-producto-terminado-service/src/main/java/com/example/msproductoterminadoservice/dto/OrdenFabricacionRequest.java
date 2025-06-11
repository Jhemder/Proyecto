package com.example.msproductoterminadoservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrdenFabricacionRequest {
    private String tipoPrenda;
    private int cantidad;
    private List<MaterialDTO> materiales;
}
