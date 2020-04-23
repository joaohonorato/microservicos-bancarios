package com.sistema.produto.gerenciarpessoa.dominio.payload;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarpessoa.dominio.enums.validadores.ValidadorEnumTipoPessoa;

import javax.validation.constraints.NotEmpty;

/**
 * Payload utilizado para criar uma pessoa
 */
public class PessoaPayload {

    @NotEmpty
    private String nome;
    @ValidadorEnumTipoPessoa(anyOf = {TipoPessoa.PESSOA_FISICA,TipoPessoa.PESSOA_JURIDICA})
    private TipoPessoa pessoa;

    public PessoaPayload() {
    }

    public PessoaPayload(String nome, TipoPessoa pessoa) {
        this.nome = nome;
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(TipoPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
