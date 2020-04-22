package com.sistema.produto.gerenciarconta.servico;

import com.sistema.produto.gerenciarconta.dominio.dtos.ContaDTO;
import com.sistema.produto.gerenciarconta.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarconta.excecoes.NumeroDeContasChegouAoLimiteExcecao;


public interface ContaServico {
    ContaDTO criarContaDePessoa(ContaPayload payload) throws NumeroDeContasChegouAoLimiteExcecao;
}