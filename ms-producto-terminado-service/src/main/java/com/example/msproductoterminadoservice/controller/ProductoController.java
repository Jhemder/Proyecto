package com.example.msproductoterminadoservice.controller;

import com.example.msproductoterminadoservice.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/producir")
    public String producirProducto() {
        try {
            productoService.producirProducto();
            return "✅ Producto producido con éxito";
        } catch (Exception e) {
            return "❌ Error al producir producto: " + e.getMessage();
        }
    }
}
