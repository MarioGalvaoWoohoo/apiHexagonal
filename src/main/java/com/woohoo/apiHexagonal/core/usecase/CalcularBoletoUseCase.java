package com.woohoo.apiHexagonal.core.usecase;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.woohoo.apiHexagonal.core.domain.Boleto;
import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;
import com.woohoo.apiHexagonal.core.domain.enums.TipoBoleto;
import com.woohoo.apiHexagonal.core.domain.enums.TipoExcecao;
import com.woohoo.apiHexagonal.core.exception.ApplicationException;
import com.woohoo.apiHexagonal.core.port.in.CalculoBoletoPort;
import com.woohoo.apiHexagonal.core.port.out.ComplementoBoletoPort;

@Component //Ou @Service para fazer a injeção de dependecias
public class CalcularBoletoUseCase implements CalculoBoletoPort{

    private final ComplementoBoletoPort complementoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {

        Boleto boleto = complementoBoletoPort.executar(codigo);

        this.validar(boleto);

        throw new UnsupportedOperationException("Unimplemented method 'executar'");
    }

    private void validar(Boleto boleto) {
        if(boleto == null) { throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO); }
        if(boleto.getTipo() != TipoBoleto.XPTO) { throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO); }
        if(boleto.getDataVencimento().isAfter(LocalDate.now())) { throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO); }
    }
    
}
