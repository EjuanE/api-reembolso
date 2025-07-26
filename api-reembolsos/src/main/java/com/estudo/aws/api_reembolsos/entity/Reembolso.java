package com.estudo.aws.api_reembolsos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Reembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private BigDecimal valor;
  
	private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusReembolso status;

    private String descricao;

    private String reciboUrl;

    @Column(nullable = false)
    private String solicitante;

}

