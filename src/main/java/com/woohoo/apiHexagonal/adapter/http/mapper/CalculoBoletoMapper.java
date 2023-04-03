package com.woohoo.apiHexagonal.adapter.http.mapper;

import org.mapstruct.Mapper;

import com.woohoo.apiHexagonal.adapter.http.dto.CalculoBoletoResponse;
import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;

@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {
    CalculoBoletoResponse toDTO(BoletoCalculado boletoCalculado);
}
