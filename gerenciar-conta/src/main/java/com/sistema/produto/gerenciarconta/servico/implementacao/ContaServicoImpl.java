package com.sistema.produto.gerenciarconta.servico.implementacao;

import com.sistema.produto.gerenciarconta.dominio.ApiResposta;
import com.sistema.produto.gerenciarconta.dominio.Conta;
import com.sistema.produto.gerenciarconta.dominio.dtos.ContaDTO;
import com.sistema.produto.gerenciarconta.dominio.fabrica.ContaFabrica;
import com.sistema.produto.gerenciarconta.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarconta.dominio.payload.ProdutoPayload;
import com.sistema.produto.gerenciarconta.excecoes.NumeroDeContasChegouAoLimiteExcecao;
import com.sistema.produto.gerenciarconta.repositorio.ContaRepositorio;
import com.sistema.produto.gerenciarconta.servico.ContaServico;
import com.sistema.produto.gerenciarconta.servico.rest.ProdutoServico;
import com.sistema.produto.gerenciarconta.util.UtilitariosDoSistema;
import com.sistema.produto.gerenciarconta.util.i18n.Mensagens;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ContaServicoImpl implements ContaServico {

    @Value("${app.agencia}")
    private String agencia;

    private ContaRepositorio contaRepositorio;
    private ContaFabrica contaFabrica;
    private ProdutoServico produtoServico;
    private UtilitariosDoSistema utilitarios;
    private Mensagens mensagens;

    public ContaServicoImpl(ContaRepositorio contaRepositorio, ContaFabrica contaFabrica, ProdutoServico produtoServico, UtilitariosDoSistema utilitarios, Mensagens mensagens) {
        this.contaRepositorio = contaRepositorio;
        this.contaFabrica = contaFabrica;
        this.produtoServico = produtoServico;
        this.utilitarios = utilitarios;
        this.mensagens = mensagens;
    }

    @Override
	public ContaDTO criarContaDePessoa(ContaPayload payload) throws NumeroDeContasChegouAoLimiteExcecao {
        if(!utilitarios.podeCriarConta()) {
            throw new NumeroDeContasChegouAoLimiteExcecao(mensagens.obterMensagem("conta.excecao.numeroLimite"));
        }
        Conta conta = new Conta();
        conta.setTipoConta(utilitarios.mapTipoPessoParaTipoConta(payload.getTipoPessoa()));
        conta.setAgencia(agencia);
        conta.setPessoaId(payload.getPessoaId());
        conta.setProdutoCadastrado(false);
        contaRepositorio.save(conta);
        ApiResposta resposta = produtoServico.criarProdutos(new ProdutoPayload(payload.getPessoaId(), conta.getNumero()));
        conta.setProdutoCadastrado(resposta.getSucesso());
        contaRepositorio.save(conta);
        return contaFabrica.buscaDto(conta);
		}


}