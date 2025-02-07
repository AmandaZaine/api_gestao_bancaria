package com.amandazaine.api_gestao_bancaria.repository;

import com.amandazaine.api_gestao_bancaria.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {
}
