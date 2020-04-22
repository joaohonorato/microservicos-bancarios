package com.sistema.produto.gerenciarconta.servico.rest.implementacao;

import com.sistema.produto.gerenciarconta.dominio.ApiResposta;
import com.sistema.produto.gerenciarconta.dominio.payload.ProdutoPayload;
import com.sistema.produto.gerenciarconta.servico.rest.ProdutoServico;
import com.sistema.produto.gerenciarconta.util.Constantes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutoServicoImpl implements ProdutoServico {

    private RestTemplate restTemplate;

    public ProdutoServicoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ApiResposta criarProdutos(ProdutoPayload payload) {
        return restTemplate.postForObject(Constantes.GERENCIAR_PRODUTO_URL, payload, ApiResposta.class);
    }
}
