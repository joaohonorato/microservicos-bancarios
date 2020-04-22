package com.sistema.produto.gerenciarproduto.servico;

import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;

public interface CartaoCreditoServico {
    CartaoCredito criarCartaoCredito(Integer score, String numeroConta);
}
