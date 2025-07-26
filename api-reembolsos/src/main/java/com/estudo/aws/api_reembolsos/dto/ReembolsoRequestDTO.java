package com.estudo.aws.api_reembolsos.dto;

import java.math.BigDecimal;

public record ReembolsoRequestDTO(
    BigDecimal valor,
    String descricao,
    String solicitante
) {}