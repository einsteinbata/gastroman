package com.bata.exemp.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoDto {
    private long idPedido;
    private int quantidade;
    private String codItem;
    private String nomeItem;
    private String detalhes;
    private BigDecimal precoUnidade;
}
