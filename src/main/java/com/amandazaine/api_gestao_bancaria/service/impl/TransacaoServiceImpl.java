package com.amandazaine.api_gestao_bancaria.service.impl;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import com.amandazaine.api_gestao_bancaria.entity.TransacaoEntity;
import com.amandazaine.api_gestao_bancaria.repository.ContaRepository;
import com.amandazaine.api_gestao_bancaria.repository.TransacaoRepository;
import com.amandazaine.api_gestao_bancaria.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    private final String CODIGO_PIX = "P";
    private final String CODIGO_CREDITO = "C";
    private final String CODIGO_DEBITO = "D";
    private final Float TAXA_CREDITO = 0.05f;
    private final Float TAXA_DEBITO = 0.03f;

    @Override
    public ContaDTO realizarTransacaoPix(Integer numeroConta, Float valor) {

        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() != 0  && conta.getSaldo() >= valor) {
                                TransacaoEntity transacao = new TransacaoEntity(CODIGO_PIX, numeroConta, valor);
                                float novoSaldo = conta.getSaldo() - valor;
                                conta.setSaldo(novoSaldo);
                                contaRepository.save(conta);
                                contaEntityAtomic.set(conta);
                                transacaoRepository.save(transacao);
                            } else {
                                throw new UnsupportedOperationException();
                            }
                        },
                        () -> { throw new NullPointerException(); }
                );

        return new ContaDTO(contaEntityAtomic.get());
    }

    @Override
    public ContaDTO realizarTransacaoCartaoCredito(Integer numeroConta, Float valor) {
        Float valorComTaxaCredito = valor + (valor * TAXA_CREDITO);

        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() != 0 && conta.getSaldo() >= valorComTaxaCredito) {
                                TransacaoEntity transacao = new TransacaoEntity(CODIGO_CREDITO, numeroConta, valor);
                                float novoSaldo = conta.getSaldo() - valorComTaxaCredito;
                                conta.setSaldo(novoSaldo);
                                contaRepository.save(conta);
                                contaEntityAtomic.set(conta);
                                transacaoRepository.save(transacao);
                            } else {
                                throw new UnsupportedOperationException();
                            }
                        },
                        () -> { throw new NullPointerException(); }
                );

        return new ContaDTO(contaEntityAtomic.get());
    }

    @Override
    public ContaDTO realizarTransacaoCartaoDebito(Integer numeroConta, Float valor) {
        Float valorComTaxaDebito = valor + (valor * TAXA_DEBITO);

        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() != 0 && conta.getSaldo() >= valorComTaxaDebito) {
                                TransacaoEntity transacao = new TransacaoEntity(CODIGO_DEBITO, numeroConta, valor);
                                float novoSaldo = conta.getSaldo() - valorComTaxaDebito;
                                conta.setSaldo(novoSaldo);
                                contaRepository.save(conta);
                                contaEntityAtomic.set(conta);
                                transacaoRepository.save(transacao);
                            } else {
                                throw new UnsupportedOperationException();
                            }
                        },
                        () -> { throw new NullPointerException(); }
                );

        return new ContaDTO(contaEntityAtomic.get());
    }
}
