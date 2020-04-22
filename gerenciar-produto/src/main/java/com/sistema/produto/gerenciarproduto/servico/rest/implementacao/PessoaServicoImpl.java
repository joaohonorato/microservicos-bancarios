package com.sistema.produto.gerenciarproduto.servico.rest.implementacao;

import com.sistema.produto.gerenciarproduto.dominio.ApiResposta;
import com.sistema.produto.gerenciarproduto.servico.rest.PessoaServico;
import com.sistema.produto.gerenciarproduto.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PessoaServicoImpl implements PessoaServico {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResposta buscaScore(Long id) {
        return restTemplate.getForObject(String.format(Constantes.GERENCIAR_PESSOA_SCORE_URL, id.toString()),ApiResposta.class);
    }
}
