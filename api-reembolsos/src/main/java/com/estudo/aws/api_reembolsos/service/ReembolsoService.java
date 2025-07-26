package com.estudo.aws.api_reembolsos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.estudo.aws.api_reembolsos.dto.ReembolsoRequestDTO;
import com.estudo.aws.api_reembolsos.dto.ReembolsoResponseDTO;
import com.estudo.aws.api_reembolsos.entity.Reembolso;
import com.estudo.aws.api_reembolsos.entity.StatusReembolso;
import com.estudo.aws.api_reembolsos.exception.RecursoNaoEncontradoException;
import com.estudo.aws.api_reembolsos.repository.ReembolsoRepository;

@Service
public class ReembolsoService {

    private final ReembolsoRepository repository;

    public ReembolsoService(ReembolsoRepository repository) {
        this.repository = repository;
    }

    public ReembolsoResponseDTO criar(ReembolsoRequestDTO dto) {
        Reembolso reembolso = new Reembolso();
        reembolso.setValor(dto.valor());
        reembolso.setDescricao(dto.descricao());
        reembolso.setSolicitante(dto.solicitante());
        reembolso.setStatus(StatusReembolso.PENDENTE);
        reembolso.setData(LocalDate.now());
        repository.save(reembolso);
        return toDTO(reembolso);
    }

    public List<ReembolsoResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ReembolsoResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Reembolso não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private ReembolsoResponseDTO toDTO(Reembolso reembolso) {
        return new ReembolsoResponseDTO(
            reembolso.getId(), reembolso.getValor(), reembolso.getData(), reembolso.getStatus().name(),
            reembolso.getDescricao(), reembolso.getReciboUrl(), reembolso.getSolicitante()
        );
    }
}
