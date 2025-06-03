package com.safewater.safewater_api.controller;

import com.safewater.safewater_api.dto.AreaDeRiscoDTO;
import com.safewater.safewater_api.service.AreaDeRiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaDeRiscoController {

    @Autowired
    private AreaDeRiscoService areaService;

    @GetMapping
    public ResponseEntity<List<AreaDeRiscoDTO>> listar() {
        return ResponseEntity.ok(areaService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDeRiscoDTO> buscar(@PathVariable Long id) {
        return areaService.buscarPorId(id)
                .map(area -> ResponseEntity.ok(areaService.toDTO(area)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AreaDeRiscoDTO> criar(@RequestBody AreaDeRiscoDTO dto) {
        AreaDeRiscoDTO novaArea = areaService.salvar(dto);
        return ResponseEntity.ok(novaArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDeRiscoDTO> atualizar(@PathVariable Long id, @RequestBody AreaDeRiscoDTO dto) {
        AreaDeRiscoDTO areaAtualizada = areaService.atualizar(id, dto);
        return areaAtualizada != null ? ResponseEntity.ok(areaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return areaService.deletar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
