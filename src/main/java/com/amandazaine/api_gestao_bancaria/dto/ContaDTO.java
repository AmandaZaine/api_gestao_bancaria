package com.amandazaine.api_gestao_bancaria.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
