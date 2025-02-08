package com.amandazaine.api_gestao_bancaria.entity;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "conta")
public class ContaEntity {

    @Id
    private Integer numeroConta;
    private Float saldo;

    public ContaEntity() {
    }

    public ContaEntity(Integer numeroConta, Float saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public ContaEntity(ContaDTO contaDTO) {
        this.numeroConta = contaDTO.getNumeroConta();
        this.saldo = contaDTO.getSaldo();
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
        ContaEntity that = (ContaEntity) o;
        return Objects.equals(numeroConta, that.numeroConta) && Objects.equals(saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta, saldo);
    }
}
