package com.sistema.produto.gerenciarpessoa.dominio;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarpessoa.dominio.enums.validadores.ValidadorEnumTipoPessoa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @Enumerated(EnumType.STRING)
    @ValidadorEnumTipoPessoa(anyOf = {TipoPessoa.PESSOA_FISICA,TipoPessoa.PESSOA_JURIDICA})
    private TipoPessoa tipoPessoa;
    @NotNull
    private Integer score;
    @NotNull
    private Boolean contaCadastrada;

    public Pessoa() {
    }

    public Pessoa(Long id, @NotEmpty String nome, TipoPessoa tipoPessoa, @NotNull Integer score, @NotNull Boolean contaCadastrada) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.score = score;
        this.contaCadastrada = contaCadastrada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getContaCadastrada() {
        return contaCadastrada;
    }

    public void setContaCadastrada(Boolean contaCadastrada) {
        this.contaCadastrada = contaCadastrada;
    }
}
