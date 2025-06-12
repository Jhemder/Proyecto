package com.example.msproductoterminadoservice.client;

import com.example.msproductoterminadoservice.dto.MaterialRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// Usa el nombre del servicio registrado en Eureka
@FeignClient(name = "ms-almacen-service")
public interface AlmacenClient {

    @PostMapping("/api/materiales/descontar")
    boolean descontarMateriales(@RequestBody List<MaterialRequestDTO> materiales);
}
