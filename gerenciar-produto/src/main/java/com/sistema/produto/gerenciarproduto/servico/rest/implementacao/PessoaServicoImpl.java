package com.sistema.produto.gerenciarproduto.servico.rest.implementacao;

import com.sistema.produto.gerenciarproduto.dominio.ApiResposta;
import com.sistema.produto.gerenciarproduto.servico.rest.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PessoaServicoImpl implements PessoaServico {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResposta buscaScore(Long id) {
        return restTemplate.getForObject(String.format("http://gerenciar-pessoa/pessoa/%s/score", id.toString()),ApiResposta.class);
    }
}
