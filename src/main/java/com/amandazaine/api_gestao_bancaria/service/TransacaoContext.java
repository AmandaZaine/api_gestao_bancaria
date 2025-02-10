package com.amandazaine.api_gestao_bancaria.service;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.dto.TransacaoDTO;
import com.amandazaine.api_gestao_bancaria.strategy.impl.CartaoCreditoStrategy;
import com.amandazaine.api_gestao_bancaria.strategy.impl.CartaoDebitoStrategy;
import com.amandazaine.api_gestao_bancaria.strategy.impl.PixStrategy;
import com.amandazaine.api_gestao_bancaria.strategy.TransacaoStrategy;

import java.util.HashMap;
import java.util.Map;

public class TransacaoContext {

    private final Map<String, TransacaoStrategy> strategies = new HashMap<>();

    public TransacaoContext(TransacaoService transacaoService) {
        strategies.put("P", new PixStrategy(transacaoService));
        strategies.put("C", new CartaoCreditoStrategy(transacaoService));
        strategies.put("D", new CartaoDebitoStrategy(transacaoService));
    }

    public TransacaoStrategy getStrategy(String tipoTransacao) {
        return strategies.get(tipoTransacao);
    }

    public ContaDTO executarTransacao(TransacaoDTO transacaoDTO) {
        String formaPagamento = transacaoDTO.getFormaPagamento().trim().toUpperCase();
        TransacaoStrategy strategy = getStrategy(formaPagamento);

        if (strategy != null) {
            return strategy.realizarTransacao(transacaoDTO.getNumeroConta(), transacaoDTO.getValor());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
