package com.woohoo.apiHexagonal.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.woohoo.apiHexagonal.core.domain.enums.TipoBoleto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoletoCalculado {
    
    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal juros;
    private TipoBoleto tipo;
}
