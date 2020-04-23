package com.sistema.produto.gerenciarpessoa.dominio.payload;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;

/**
 * Payload utilizado para criar uma conta
 */
public class ContaPayload {
    private Long pessoaId;
    private TipoPessoa tipoPessoa;

    public ContaPayload() {
    }

    public ContaPayload(Long pessoaId, TipoPessoa tipoPessoa) {
        this.pessoaId = pessoaId;
        this.tipoPessoa = tipoPessoa;
    }

    public Long getPessoaId() {
        return this.pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public TipoPessoa getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public ContaPayload pessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
        return this;
    }

    public ContaPayload tipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " pessoaId='" + getPessoaId() + "'" +
            ", tipoPessoa='" + getTipoPessoa() + "'" +
            "}";
    }

}
