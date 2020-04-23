package com.sistema.produto.gerenciarproduto.servico;

import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;

/**
 * Servico para criacao de cheque especial
 */
public interface ChequeEspecialServico {
    ChequeEspecial criarChequeEspecial(int score, String numeroConta);
}
