package com.woohoo.apiHexagonal.adapter.datasource.mapper;

import javax.swing.Spring;

import org.mapstruct.Mapper;

import com.woohoo.apiHexagonal.adapter.datasource.database.entity.BoletoCalculadoEntity;
import com.woohoo.apiHexagonal.core.domain.BoletoCalculado;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {
    
    BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);

}
