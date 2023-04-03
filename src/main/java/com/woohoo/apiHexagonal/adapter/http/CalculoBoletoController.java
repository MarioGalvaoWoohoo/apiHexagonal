package com.woohoo.apiHexagonal.adapter.http;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woohoo.apiHexagonal.adapter.http.dto.CalculoBoletoResponse;
import com.woohoo.apiHexagonal.adapter.http.dto.CalculoBoletoResquest;
import com.woohoo.apiHexagonal.adapter.http.mapper.CalculoBoletoMapper;
import com.woohoo.apiHexagonal.core.port.in.CalculoBoletoPort;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {
    
    private final CalculoBoletoPort calculoBoletoPort;

    private final CalculoBoletoMapper mapper;

    public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper mapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.mapper = mapper;
    }

    @PostMapping(value="/calculo")
    @Operation(summary = "Calcular juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoResquest boleto) {
        var boletoCalulado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());
        
        return ResponseEntity.ok(mapper.toDTO(boletoCalulado));
    }
    
}
