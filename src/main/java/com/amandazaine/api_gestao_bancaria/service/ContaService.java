package com.amandazaine.api_gestao_bancaria.service;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;

public interface ContaService {
    void saveConta(ContaDTO conta);
    ContaDTO findConta(Integer numeroConta);
}
