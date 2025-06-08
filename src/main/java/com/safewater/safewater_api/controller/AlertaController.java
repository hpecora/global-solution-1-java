package com.safewater.safewater_api.controller;

import com.safewater.safewater_api.dto.AlertaDTO;
import com.safewater.safewater_api.model.Alerta;
import com.safewater.safewater_api.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public ResponseEntity<List<AlertaDTO>> listar() {
        return ResponseEntity.ok(alertaService.buscarTodosDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaDTO> buscar(@PathVariable Long id) {
        return alertaService.buscarDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody AlertaDTO dto) {
        return ResponseEntity.ok(alertaService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(@PathVariable Long id, @RequestBody AlertaDTO dto) {
        Alerta atualizado = alertaService.atualizar(id, dto);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return alertaService.deletar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
