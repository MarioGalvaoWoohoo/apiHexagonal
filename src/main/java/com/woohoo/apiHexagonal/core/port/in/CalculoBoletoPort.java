package com.woohoo.apiHexagonal.core.port.in;

import java.time.LocalDate;

import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;

public interface CalculoBoletoPort {

    BoletoCalculado executar(String codigo, LocalDate dataPagamento);
    
}
