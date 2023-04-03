package com.woohoo.apiHexagonal.adapter.datasource.database;

import org.springframework.stereotype.Component;

import com.woohoo.apiHexagonal.adapter.datasource.database.repository.BoletoCalculadoRepository;
import com.woohoo.apiHexagonal.adapter.datasource.mapper.BoletoCalculadoMapper;
import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;
import com.woohoo.apiHexagonal.core.port.out.SalvarCalculoBoletoPort;

@Component
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {
    
    private final BoletoCalculadoRepository repository;
    private final BoletoCalculadoMapper mapper;


    public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    

    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        var entity = mapper.toEntity(boletoCalculado);
        repository.save(entity);
    }
}
