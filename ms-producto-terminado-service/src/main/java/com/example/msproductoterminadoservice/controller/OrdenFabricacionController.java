package com.example.msproductoterminadoservice.controller;

import com.example.msproductoterminadoservice.dto.OrdenFabricacionRequest;
import com.example.msproductoterminadoservice.entity.OrdenFabricacion;
import com.example.msproductoterminadoservice.service.OrdenFabricacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenFabricacionController {

    private final OrdenFabricacionService ordenService;

    @PostMapping
    public OrdenFabricacion crearOrden(@RequestBody OrdenFabricacionRequest request) {
        return ordenService.crearOrdenFabricacion(request);
    }
}
