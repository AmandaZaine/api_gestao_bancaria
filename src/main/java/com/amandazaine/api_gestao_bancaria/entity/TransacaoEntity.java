package com.amandazaine.api_gestao_bancaria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String formaPagamento;
    private Integer numeroConta;
    private Float valor;

    public TransacaoEntity(String formaPagamento, Integer numeroConta, Float valor) {
        this.formaPagamento = formaPagamento;
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public TransacaoEntity() {
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
