package com.sistema.produto.gerenciarproduto.servico;

import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;

public interface ChequeEspecialServico {
    ChequeEspecial criarChequeEspecial(int score, String numeroConta);
}
