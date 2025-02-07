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
    ContaRepository contaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Override
    public ContaDTO realizarTransacaoPix(Integer numeroConta, Float valor) {
        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        TransacaoEntity transacao = new TransacaoEntity("P", numeroConta, valor);

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() !=0  && conta.getSaldo() >= valor) {
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

        ContaEntity contaEntity = contaEntityAtomic.get();
        ContaDTO contaDTO = new ContaDTO(contaEntity.getNumeroConta(), contaEntity.getSaldo());
        return contaDTO;
    }

    @Override
    public ContaDTO realizarTransacaoCartaoCredito(Integer numeroConta, Float valor) {
        Float valorComTaxaCredito = valor + (valor * 0.05f);

        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        TransacaoEntity transacao = new TransacaoEntity("C", numeroConta, valor);

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() != 0 && conta.getSaldo() >= valorComTaxaCredito) {
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

        ContaEntity contaEntity = contaEntityAtomic.get();
        ContaDTO contaDTO = new ContaDTO(contaEntity.getNumeroConta(), contaEntity.getSaldo());
        return contaDTO;
    }

    @Override
    public ContaDTO realizarTransacaoCartaoDebito(Integer numeroConta, Float valor) {
        Float valorComTaxaDebito = valor + (valor * 0.03f);

        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        TransacaoEntity transacao = new TransacaoEntity("D", numeroConta, valor);

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> {
                            if(conta.getSaldo() != 0 && conta.getSaldo() >= valorComTaxaDebito) {
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

        ContaEntity contaEntity = contaEntityAtomic.get();
        ContaDTO contaDTO = new ContaDTO(contaEntity.getNumeroConta(), contaEntity.getSaldo());
        return contaDTO;
    }
}
