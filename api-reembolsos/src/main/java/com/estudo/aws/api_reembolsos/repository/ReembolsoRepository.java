package com.estudo.aws.api_reembolsos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.aws.api_reembolsos.entity.Reembolso;

public interface ReembolsoRepository extends JpaRepository<Reembolso, Long> {
    List<Reembolso> findBySolicitante(String solicitante);
}
