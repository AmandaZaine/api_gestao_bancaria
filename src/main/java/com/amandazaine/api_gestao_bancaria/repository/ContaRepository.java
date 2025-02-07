package com.amandazaine.api_gestao_bancaria.repository;

import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer> {
}
