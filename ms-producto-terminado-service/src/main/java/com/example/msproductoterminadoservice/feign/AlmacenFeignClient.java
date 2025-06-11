package com.example.msproductoterminadoservice.feign;

import com.example.msproductoterminadoservice.dto.MaterialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// El nombre debe coincidir con el "spring.application.name" de ms-almacen-service
@FeignClient(name = "ms-almacen-service")
public interface AlmacenFeignClient {

    @PostMapping("/api/materiales/descontar")
    boolean descontarMaterial(
            @RequestParam("nombre") String nombre,
            @RequestParam("tipo") String tipo,
            @RequestParam("color") String color,
            @RequestParam("cantidad") double cantidad
    );

    void descontarMateriales(List<MaterialDTO> materiales);
}
