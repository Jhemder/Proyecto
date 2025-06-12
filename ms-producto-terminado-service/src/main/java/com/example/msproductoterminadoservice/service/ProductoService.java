package com.example.msproductoterminadoservice.service;


import com.example.msproductoterminadoservice.client.AlmacenClient;
import com.example.msproductoterminadoservice.dto.MaterialRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private AlmacenClient almacenClient;

    public void producirProducto() {
        MaterialRequestDTO dto = MaterialRequestDTO.builder()
                .nombre("Tela Dry Fit")
                .tipo("Tela")
                .color("Negro")
                .cantidad(3.0)
                .build();

        boolean ok = almacenClient.descontarMaterial(dto);
        if (ok) {
            System.out.println("✅ Material descontado con éxito.");
        } else {
            throw new RuntimeException("❌ No se pudo descontar el material. No hay suficiente stock.");
        }
    }
}
