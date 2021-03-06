package com.sistema.produto.gerenciarpessoa.servico.rest.implementacao;

import com.sistema.produto.gerenciarpessoa.dominio.ApiResposta;
import com.sistema.produto.gerenciarpessoa.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarpessoa.servico.rest.ContaServico;
import com.sistema.produto.gerenciarpessoa.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContaServicoImpl implements ContaServico{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResposta cadastrarConta(ContaPayload payload) {
        ApiResposta resposta = restTemplate.postForObject(Constantes.GERENCIAR_CONTA_URL, payload, ApiResposta.class);
        return resposta;
    }
}
