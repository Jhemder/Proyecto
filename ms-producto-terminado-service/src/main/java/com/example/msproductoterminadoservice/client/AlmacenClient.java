package com.example.msproductoterminadoservice.client;

import com.example.msproductoterminadoservice.dto.MaterialRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-almacen", url = "http://localhost:8081")
public interface AlmacenClient {

    @PostMapping("/api/materiales/descontar")
    boolean descontarMaterial(@RequestBody MaterialRequestDTO dto);
}
