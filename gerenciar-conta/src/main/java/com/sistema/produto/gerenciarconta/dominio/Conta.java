package com.sistema.produto.gerenciarconta.dominio;

import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;
import com.sistema.produto.gerenciarconta.dominio.enums.validadores.ValidadorEnum;
import com.sistema.produto.gerenciarconta.dominio.gerador.GeradorNumerosSeisDigitos;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq")
    @GenericGenerator(
            name="conta_seq",
            strategy = "com.sistema.produto.gerenciarconta.dominio.gerador.GeradorNumerosSeisDigitos",
            parameters = {
                    @Parameter(name = GeradorNumerosSeisDigitos.INCREMENT_PARAM, value = "1")
            }
    )
    @NotEmpty
    private String numero;
    @NotEmpty
    private String agencia;
    @Enumerated(EnumType.STRING)
    @ValidadorEnum(enumClass = TipoConta.class)
    private TipoConta tipoConta;
    @NotNull
    private Long pessoaId;
    @NotNull
    private Boolean produtoCadastrado;


    public Conta() {
    }

    public Conta(String numero, String agencia, TipoConta tipoConta, Long pessoaId, Boolean produtoCadastrado) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.pessoaId = pessoaId;
        this.produtoCadastrado = produtoCadastrado;
    }


    public Conta(String numero) {
        this.numero = numero;
    }

    public Conta(@NotEmpty String agencia, TipoConta tipoConta, @NotNull Long pessoaId, @NotNull Boolean produtoCadastrado) {
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.pessoaId = pessoaId;
        this.produtoCadastrado = produtoCadastrado;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getProdutoCadastrado() {
        return produtoCadastrado;
    }

    public void setProdutoCadastrado(Boolean produtoCadastrado) {
        this.produtoCadastrado = produtoCadastrado;
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
