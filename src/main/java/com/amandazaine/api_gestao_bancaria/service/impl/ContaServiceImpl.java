package com.amandazaine.api_gestao_bancaria.service.impl;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import com.amandazaine.api_gestao_bancaria.repository.ContaRepository;
import com.amandazaine.api_gestao_bancaria.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public void saveConta(ContaDTO contaDTO) {
        ContaEntity contaEntity = new ContaEntity(contaDTO);

        contaRepository
                .findById(contaEntity.getNumeroConta())
                .ifPresentOrElse(
                        conta -> { throw new IllegalArgumentException(); },
                        () -> { contaRepository.save(contaEntity); }
                );
    }

    @Override
    public ContaDTO findConta(Integer numeroConta) {
        AtomicReference<ContaEntity> contaEntityAtomic = new AtomicReference<>();

        contaRepository
                .findById(numeroConta)
                .ifPresentOrElse(
                        conta -> { contaEntityAtomic.set(conta); },
                        () -> { throw new RuntimeException(); }
                );

        ContaEntity contaEntity = contaEntityAtomic.get();
        ContaDTO contaDTO = new ContaDTO(contaEntity.getNumeroConta(), contaEntity.getSaldo());
        return contaDTO;
    }
}
