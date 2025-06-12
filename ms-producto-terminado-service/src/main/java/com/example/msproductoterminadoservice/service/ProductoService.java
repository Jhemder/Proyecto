package com.example.msproductoterminadoservice.service;

import com.example.msproductoterminadoservice.client.AlmacenClient;
import com.example.msproductoterminadoservice.dto.MaterialRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private AlmacenClient almacenClient;

    public void producirProducto() {
        List<MaterialRequestDTO> materiales = Arrays.asList(
                MaterialRequestDTO.builder()
                        .nombre("Tela Dry Fit")
                        .tipo("Tela")
                        .color("Negro")
                        .cantidad(3.0)
                        .unidadMedida("metro")
                        .costoUnitario(10.0)
                        .proveedor("Textiles S.A.")
                        .build(),
                MaterialRequestDTO.builder()
                        .nombre("Hilo resistente")
                        .tipo("Hilo")
                        .color("Blanco")
                        .cantidad(1.5)
                        .unidadMedida("metro")
                        .costoUnitario(2.0)
                        .proveedor("Costuras SAC")
                        .build()
        );

        boolean ok = almacenClient.descontarMateriales(materiales);
        if (ok) {
            System.out.println("✅ Todos los materiales fueron descontados correctamente.");
        } else {
            throw new RuntimeException("❌ No se pudo descontar uno o más materiales.");
        }
    }
}
