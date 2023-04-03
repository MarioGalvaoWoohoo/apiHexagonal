package com.woohoo.apiHexagonal.adapter.datasource.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woohoo.apiHexagonal.adapter.datasource.database.entity.BoletoCalculadoEntity;

@Repository
public interface BoletoCalculadoRepository extends JpaRepository<BoletoCalculadoEntity, Long>{
    
}
