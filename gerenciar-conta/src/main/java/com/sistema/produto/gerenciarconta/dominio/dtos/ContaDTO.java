package com.sistema.produto.gerenciarconta.dominio.dtos;

import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;

public class ContaDTO {
    private String numero;
    private String agencia;
    private TipoConta tipoConta;
    private Long pessoaId;
    private Boolean produtoCadastrados;

    public ContaDTO() {
    }

    public ContaDTO(String numero, String agencia, TipoConta tipoConta, Long pessoaId, Boolean produtoCadastrados) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.pessoaId = pessoaId;
        this.produtoCadastrados = produtoCadastrados;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public TipoConta getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getPessoaId() {
        return this.pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Boolean getProdutoCadastrados() {
        return produtoCadastrados;
    }

    public void setProdutoCadastrados(Boolean produtoCadastrados) {
        this.produtoCadastrados = produtoCadastrados;
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", agencia='" + getAgencia() + "'" +
            ", tipoConta='" + getTipoConta() + "'" +
            ", pessoaId='" + getPessoaId() + "'" +
            "}";
    }

}
