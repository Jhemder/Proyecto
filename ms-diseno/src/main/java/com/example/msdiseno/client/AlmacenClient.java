package com.example.msdiseno.client;

import com.example.msdiseno.dto.DescuentoMaterialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ms-almacen", url = "http://localhost:8081") // Ajusta el puerto si es distinto
public interface AlmacenClient {

    @PostMapping("/materiales/descontar-multiple")
    void descontarMateriales(@RequestBody List<DescuentoMaterialDTO> lista);
}
