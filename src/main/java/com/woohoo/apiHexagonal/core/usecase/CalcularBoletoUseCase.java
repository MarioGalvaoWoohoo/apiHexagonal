package com.woohoo.apiHexagonal.core.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.woohoo.apiHexagonal.core.domain.Boleto;
import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;
import com.woohoo.apiHexagonal.core.domain.enums.TipoBoleto;
import com.woohoo.apiHexagonal.core.domain.enums.TipoExcecao;
import com.woohoo.apiHexagonal.core.exception.ApplicationException;
import com.woohoo.apiHexagonal.core.port.in.CalculoBoletoPort;
import com.woohoo.apiHexagonal.core.port.out.ComplementoBoletoPort;
import com.woohoo.apiHexagonal.core.port.out.SalvarCalculoBoletoPort;

@Component //Ou @Service para fazer a injeção de dependecias
public class CalcularBoletoUseCase implements CalculoBoletoPort{

    private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort, SalvarCalculoBoletoPort salvarCalculoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
        this.salvarCalculoBoletoPort = salvarCalculoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {

        var boleto = complementoBoletoPort.executar(codigo);
        this.validar(boleto);

        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(BigDecimal.valueOf(100));
        var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);

        var boletoCalculado = BoletoCalculado.builder()
            .codigo(boleto.getCodigo())
            .dataPagamento(dataPagamento)
            .juros(juros)
            .dataVencimento(boleto.getDataVencimento())
            .valorOriginal(boleto.getValor())
            .valor(boleto.getValor().add(juros))
            .tipo(boleto.getTipo())
            .build();

        salvarCalculoBoletoPort.executar(boletoCalculado);
        return boletoCalculado;
    }

    private void validar(Boleto boleto) {
        if(boleto == null) { throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO); }
        if(boleto.getTipo() != TipoBoleto.XPTO) { throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO); }
        if(boleto.getDataVencimento().isAfter(LocalDate.now())) { throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO); }
    }

    private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }
    
}
