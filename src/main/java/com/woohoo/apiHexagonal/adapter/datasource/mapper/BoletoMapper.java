package com.woohoo.apiHexagonal.adapter.datasource.mapper;

import org.mapstruct.Mapper;

import com.woohoo.apiHexagonal.adapter.datasource.integration.dto.BoletoDTO;
import com.woohoo.apiHexagonal.core.domain.Boleto;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    Boleto toDomain(BoletoDTO boletoDTO);
}
