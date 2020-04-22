package com.sistema.produto.gerenciarpessoa.dominio.dtos;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;

public class PessoaDTO {

    private Long id;
    private String nome;
    private TipoPessoa tipoPessoa;
    private int score;
    private Boolean contaCadastrada;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public PessoaDTO(Long id, String nome, TipoPessoa tipoPessoa, int score, Boolean contaCadastrada) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Boolean getContaCadastrada() {
        return contaCadastrada;
    }

    public void setContaCadastrada(Boolean contaCadastrada) {
        this.contaCadastrada = contaCadastrada;
    }
}
