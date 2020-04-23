package com.sistema.produto.gerenciarconta.dominio.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * Payload utilizado para criar um produto
 */
public class ProdutoPayload {
    @NotNull
    private Long pessoaId;
    @NotEmpty
    private String numeroConta;

    public ProdutoPayload() {
    }

    public ProdutoPayload(Long pessoaId, String numeroConta) {
        this.pessoaId = pessoaId;
        this.numeroConta = numeroConta;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
}
