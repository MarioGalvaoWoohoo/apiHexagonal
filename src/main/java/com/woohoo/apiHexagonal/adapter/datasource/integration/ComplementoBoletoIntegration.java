package com.woohoo.apiHexagonal.adapter.datasource.integration;

import org.springframework.stereotype.Component;

import com.woohoo.apiHexagonal.adapter.datasource.integration.client.ComplementoBoletoClient;
import com.woohoo.apiHexagonal.adapter.datasource.mapper.BoletoMapper;
import com.woohoo.apiHexagonal.core.domain.Boleto;
import com.woohoo.apiHexagonal.core.port.out.ComplementoBoletoPort;
@Component
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {
    
    private final ComplementoBoletoClient client;
    private final BoletoMapper mapper;

    public ComplementoBoletoIntegration(ComplementoBoletoClient client, BoletoMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDto = client.getBoleto(codigo);
        return mapper.toDomain(boletoDto);
    }

}
