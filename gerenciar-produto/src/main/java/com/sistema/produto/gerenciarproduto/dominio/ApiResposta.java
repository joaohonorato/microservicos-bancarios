package com.sistema.produto.gerenciarproduto.dominio;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiResposta<T> {
    private Boolean sucesso;
    private String mensagem;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T resultado;

    public ApiResposta() {
    }

    public ApiResposta(Boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public ApiResposta(Boolean sucesso, String mensagem, T resultado) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.resultado = resultado;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public T getResultado() {
        return resultado;
    }

    public void setResultado(T resultado) {
        this.resultado = resultado;
    }
}
