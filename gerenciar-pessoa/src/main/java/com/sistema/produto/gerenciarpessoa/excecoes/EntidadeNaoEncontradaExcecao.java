package com.sistema.produto.gerenciarpessoa.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaExcecao() {
    }

    public EntidadeNaoEncontradaExcecao(String message) {
        super(message);
    }
}