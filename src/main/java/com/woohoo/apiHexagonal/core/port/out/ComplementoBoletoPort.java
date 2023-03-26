package com.woohoo.apiHexagonal.core.port.out;

import com.woohoo.apiHexagonal.core.domain.Boleto;

public interface ComplementoBoletoPort {
    Boleto executar (String codigo);
}
