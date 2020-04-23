package com.sistema.produto.gerenciarconta.controlador;

import com.sistema.produto.gerenciarconta.dominio.ApiResposta;
import com.sistema.produto.gerenciarconta.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarconta.excecoes.NumeroDeContasChegouAoLimiteExcecao;
import com.sistema.produto.gerenciarconta.servico.ContaServico;
import com.sistema.produto.gerenciarconta.util.i18n.Mensagens;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Endpoint da conta
 */
@RestController
@RequestMapping("conta")
public class ContaControlador {

    private ContaServico contaServico;

    private Mensagens mensagens;

    /**
     * Construtor para injecao de dependecias
     * @param contaServico
     * @param mensagens
     */
    public ContaControlador(ContaServico contaServico, Mensagens mensagens) {
        this.contaServico = contaServico;
        this.mensagens = mensagens;
    }

    /**
     * Endpoint responsavel por criar uma conta.
     * @param payload - Informacoes referente a conta a ser criada
     * @return um objeco com informacoes de sucesso e mensagem com detalhe
     * @throws NumeroDeContasChegouAoLimiteExcecao - Caso as contas ultrapesse o numero limite de contas
     */
    @PostMapping
    public ResponseEntity<ApiResposta> criarContaParaPessoa(@Valid @RequestBody ContaPayload payload) throws NumeroDeContasChegouAoLimiteExcecao {
        contaServico.criarContaDePessoa(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResposta<>(true, mensagens.obterMensagem("conta.criada.sucesso")));
    }
}