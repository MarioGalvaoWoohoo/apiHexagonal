package com.woohoo.apiHexagonal.adapter.http.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.woohoo.apiHexagonal.core.domain.enums.TipoBoleto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculoBoletoResponse {
    
    private String codigo;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    private BigDecimal valor;

    private TipoBoleto tipo;
}
