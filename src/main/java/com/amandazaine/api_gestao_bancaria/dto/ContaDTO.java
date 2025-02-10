package com.amandazaine.api_gestao_bancaria.dto;

import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude
public class ContaDTO {

    @JsonProperty("numero_conta")
    private Integer numeroConta;

    private Float saldo;

    public ContaDTO() {
    }

    public ContaDTO(Integer numeroConta, Float saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public ContaDTO(ContaEntity contaEntity) {
        this.numeroConta = contaEntity.getNumeroConta();
        this.saldo = contaEntity.getSaldo();
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaDTO contaDTO = (ContaDTO) o;
        return Objects.equals(numeroConta, contaDTO.numeroConta) && Objects.equals(saldo, contaDTO.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta, saldo);
    }
}
