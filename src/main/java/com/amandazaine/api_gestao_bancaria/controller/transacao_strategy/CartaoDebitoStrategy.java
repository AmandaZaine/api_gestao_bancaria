package com.amandazaine.api_gestao_bancaria.controller.transacao_strategy;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.service.TransacaoService;

public class CartaoDebitoStrategy implements TransacaoStrategy {

    private final TransacaoService transacaoService;

    public CartaoDebitoStrategy(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Override
    public ContaDTO realizarTransacao(Integer numeroConta, Float valor) {
        return transacaoService.realizarTransacaoCartaoDebito(numeroConta, valor);
    }
}
