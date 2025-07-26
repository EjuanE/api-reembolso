package com.estudo.aws.api_reembolsos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.aws.api_reembolsos.dto.ReembolsoRequestDTO;
import com.estudo.aws.api_reembolsos.dto.ReembolsoResponseDTO;
import com.estudo.aws.api_reembolsos.service.ReembolsoService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reembolsos")
@RequiredArgsConstructor
public class ReembolsoController {

    private final ReembolsoService reembolsoService;

    @PostMapping
    public ResponseEntity<ReembolsoResponseDTO> criarReembolso(
            @RequestBody @Valid ReembolsoRequestDTO dto
    ) {
        return ResponseEntity.ok(reembolsoService.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReembolsoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reembolsoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ReembolsoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(reembolsoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reembolsoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
