package com.safewater.safewater_api.controller;

import com.safewater.safewater_api.dto.RotaSeguraDTO;
import com.safewater.safewater_api.model.RotaSegura;
import com.safewater.safewater_api.service.RotaSeguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaSeguraController {

    @Autowired
    private RotaSeguraService rotaService;

    @GetMapping
    public ResponseEntity<List<RotaSeguraDTO>> listar() {
        return ResponseEntity.ok(rotaService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaSeguraDTO> buscar(@PathVariable Long id) {
        return rotaService.buscarPorId(id)
                .map(rota -> ResponseEntity.ok(rotaService.toDTO(rota)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RotaSeguraDTO> criar(@RequestBody RotaSeguraDTO dto) {
        RotaSeguraDTO rotaCriada = rotaService.salvar(dto);
        return ResponseEntity.ok(rotaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotaSeguraDTO> atualizar(@PathVariable Long id, @RequestBody RotaSeguraDTO dto) {
        RotaSeguraDTO rotaAtualizada = rotaService.atualizar(id, dto);
        return rotaAtualizada != null ? ResponseEntity.ok(rotaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return rotaService.deletar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
