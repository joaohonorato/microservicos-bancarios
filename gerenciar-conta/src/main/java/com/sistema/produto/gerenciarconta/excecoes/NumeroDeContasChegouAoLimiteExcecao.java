package com.sistema.produto.gerenciarconta.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excecao a ser lancada quando o numero de contas criadas passou do limite
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NumeroDeContasChegouAoLimiteExcecao extends Throwable {
	private static final long serialVersionUID = 1L;

	public NumeroDeContasChegouAoLimiteExcecao(String mensagemLimite) {
		super(mensagemLimite);
	}
	public NumeroDeContasChegouAoLimiteExcecao(Throwable ex) {
		super(ex);
    }
	public NumeroDeContasChegouAoLimiteExcecao(String mensagemLimite, Throwable ex) {
		super(mensagemLimite, ex);
    }
}
