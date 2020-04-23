package com.sistema.produto.gerenciarproduto.servico;

import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;

/**
 * Servico para criacao de cartao de credito
 */
public interface CartaoCreditoServico {
    CartaoCredito criarCartaoCredito(Integer score, String numeroConta);
}
