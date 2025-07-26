package com.estudo.aws.api_reembolsos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReembolsoResponseDTO(
	    Long id,
	    BigDecimal valor,
	    LocalDate data,
	    String status,
	    String descricao,
	    String reciboUrl,
	    String solicitante
	) {}