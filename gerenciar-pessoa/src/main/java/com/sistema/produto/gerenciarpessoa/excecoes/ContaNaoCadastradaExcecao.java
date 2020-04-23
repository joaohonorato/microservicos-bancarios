package com.sistema.produto.gerenciarpessoa.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excecao a ser lancada quando o nao foi possivel cadastrar a conta
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class ContaNaoCadastradaExcecao extends Throwable {

	private static final long serialVersionUID = 1L;

	public ContaNaoCadastradaExcecao() {
    }

    public ContaNaoCadastradaExcecao(String message) {
        super(message);
    }

    public ContaNaoCadastradaExcecao(String message, Throwable ex) {
        super(message, ex);
    }

}
