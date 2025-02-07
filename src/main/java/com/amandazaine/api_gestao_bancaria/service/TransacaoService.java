package com.amandazaine.api_gestao_bancaria.service;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;

public interface TransacaoService {
    ContaDTO realizarTransacaoPix(Integer numeroConta, Float valor);
    ContaDTO realizarTransacaoCartaoCredito(Integer numeroConta, Float valor);
    ContaDTO realizarTransacaoCartaoDebito(Integer numeroConta, Float valor);
}
