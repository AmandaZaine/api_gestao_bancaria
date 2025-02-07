package com.amandazaine.api_gestao_bancaria.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class TransacaoDTO {

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    @JsonProperty("numero_conta")
    private Integer numeroConta;

    private Float valor;

    public TransacaoDTO(String formaPagamento, Integer numeroConta, Float valor) {
        this.formaPagamento = formaPagamento;
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public TransacaoDTO() {
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }
}
