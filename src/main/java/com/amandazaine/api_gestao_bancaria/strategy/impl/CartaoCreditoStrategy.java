package com.amandazaine.api_gestao_bancaria.strategy.impl;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.service.TransacaoService;
import com.amandazaine.api_gestao_bancaria.strategy.TransacaoStrategy;

public class CartaoCreditoStrategy implements TransacaoStrategy {

    private final TransacaoService transacaoService;

    public CartaoCreditoStrategy(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Override
    public ContaDTO realizarTransacao(Integer numeroConta, Float valor) {
        return transacaoService.realizarTransacaoCartaoCredito(numeroConta, valor);
    }
}
