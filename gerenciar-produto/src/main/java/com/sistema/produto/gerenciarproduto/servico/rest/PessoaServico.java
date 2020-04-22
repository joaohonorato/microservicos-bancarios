package com.sistema.produto.gerenciarproduto.servico.rest;

import com.sistema.produto.gerenciarproduto.dominio.ApiResposta;

public interface PessoaServico {
    ApiResposta<Integer> buscaScore(Long id);
}
