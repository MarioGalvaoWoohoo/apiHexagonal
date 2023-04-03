package com.woohoo.apiHexagonal.adapter.datasource.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.woohoo.apiHexagonal.core.domain.enums.TipoBoleto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boleto_calculado")
@Getter
@Setter
public class BoletoCalculadoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column(name = "valor_original")
    private BigDecimal valorOriginal;

    @Column
    private BigDecimal valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column
    private BigDecimal juros;

    @Column
    private TipoBoleto tipo;
    

}
