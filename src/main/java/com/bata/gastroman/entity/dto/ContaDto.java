package com.bata.gastroman.entity.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ContaDto {
    private long contaId;
    private List<PedidoDto> pedidos;
    private String dataAbertura;
    private String dataFecho;
    private BigDecimal total;
}
