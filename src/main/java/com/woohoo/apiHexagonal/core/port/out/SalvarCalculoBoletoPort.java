package com.woohoo.apiHexagonal.core.port.out;

import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado);
}
