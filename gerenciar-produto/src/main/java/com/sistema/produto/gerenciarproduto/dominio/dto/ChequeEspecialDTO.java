package com.sistema.produto.gerenciarproduto.dominio.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Entidade utilizada para trafegar dados entre camadas
 */
@Entity
public class ChequeEspecialDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal limite;
    @NotEmpty
    private String numeroConta;
    @NotNull
    private Boolean habilidatada;

    public ChequeEspecialDTO() {
    }

    public ChequeEspecialDTO(String numeroConta, Boolean habilidatada) {
        this.numeroConta = numeroConta;
        this.habilidatada = habilidatada;
    }

    public ChequeEspecialDTO(BigDecimal limite, String numeroConta, Boolean habilidatada) {
        this.limite = limite;
        this.numeroConta = numeroConta;
        this.habilidatada = habilidatada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
}
