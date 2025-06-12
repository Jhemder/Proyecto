package com.example.msproductoterminadoservice.feign;

import com.example.msproductoterminadoservice.dto.MaterialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-almacen-service")
public interface AlmacenFeignClient {

    @PostMapping("/api/materiales/descontar")
    void descontarMateriales(@RequestBody List<MaterialDTO> materiales);
}
