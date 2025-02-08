package com.amandazaine.api_gestao_bancaria.strategy;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;

public interface TransacaoStrategy {
    ContaDTO realizarTransacao(Integer numeroConta, Float valor);
}
