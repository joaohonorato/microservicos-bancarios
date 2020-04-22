package com.sistema.produto.gerenciarconta.servico;

import com.sistema.produto.gerenciarconta.dominio.ApiResposta;
import com.sistema.produto.gerenciarconta.dominio.Conta;
import com.sistema.produto.gerenciarconta.dominio.dtos.ContaDTO;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarconta.dominio.fabrica.ContaFabrica;
import com.sistema.produto.gerenciarconta.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarconta.excecoes.NumeroDeContasChegouAoLimiteExcecao;
import com.sistema.produto.gerenciarconta.repositorio.ContaRepositorio;
import com.sistema.produto.gerenciarconta.servico.implementacao.ContaServicoImpl;
import com.sistema.produto.gerenciarconta.servico.rest.ProdutoServico;
import com.sistema.produto.gerenciarconta.util.UtilitariosDoSistema;
import com.sistema.produto.gerenciarconta.util.i18n.Mensagens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class ContaServicoTest {

    @Mock
    private ContaRepositorio contaRepositorio;

    @Mock
    private ContaFabrica contaFabrica;

    @Mock
    private ProdutoServico produtoServico;

    @Mock
    private UtilitariosDoSistema utilitariosDoSistema;

    @Mock
    private Mensagens mensagens;

    @InjectMocks
    private ContaServicoImpl contaServico;

    @Value("${app.agencia}")
    private String agencia;

    @Test
    public void criarContaQuando_ProdutoServicoComSucesso_RetornaContaDTOPreenchido() throws NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payloadPF = new ContaPayload(1L, TipoPessoa.PESSOA_FISICA);
        Conta contaPF = new Conta("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        ContaDTO respostaPF = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);

        given(contaRepositorio.save(Mockito.any())).willReturn(contaPF);
        given(contaFabrica.buscaDto(Mockito.any())).willReturn(respostaPF);
        given(produtoServico.criarProdutos(Mockito.any())).willReturn(new ApiResposta(true, "Mensagem sucesso"));
        given(utilitariosDoSistema.podeCriarConta()).willReturn(true);
        given(utilitariosDoSistema.mapTipoPessoParaTipoConta(Mockito.any())).willReturn(TipoConta.CONTA_CORRENTE);

        ContaDTO resultado = contaServico.criarContaDePessoa(payloadPF);
        assertThat(resultado.getNumero()).isEqualTo(respostaPF.getNumero());
        assertThat(resultado.getProdutoCadastrados()).isTrue();
    }
    @Test
    public void criarContaQuando_ProdutoServicoSemSucesso_RetornaContaDTOPreenchido() throws NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payloadPF = new ContaPayload(1L, TipoPessoa.PESSOA_FISICA);
        Conta contaPF = new Conta("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        ContaDTO respostaPF = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, false);

        given(contaRepositorio.save(Mockito.any())).willReturn(contaPF);
        given(contaFabrica.buscaDto(Mockito.any())).willReturn(respostaPF);
        given(produtoServico.criarProdutos(Mockito.any())).willReturn(new ApiResposta(false, "Mensagem erro"));
        given(utilitariosDoSistema.podeCriarConta()).willReturn(true);
        given(utilitariosDoSistema.mapTipoPessoParaTipoConta(Mockito.any())).willReturn(TipoConta.CONTA_CORRENTE);

        ContaDTO resultado = contaServico.criarContaDePessoa(payloadPF);
        assertThat(resultado.getNumero()).isEqualTo(respostaPF.getNumero());
        assertThat(resultado.getProdutoCadastrados()).isFalse();
    }
    @Test
    public void criarContaQuando_NumeroDeContasChegouAoLimite() throws NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payloadPF = new ContaPayload(1L, TipoPessoa.PESSOA_FISICA);
        given(utilitariosDoSistema.podeCriarConta()).willReturn(false);
        given(mensagens.obterMensagem(Mockito.any())).willReturn("Não é possível criar mais contas, número máximo atingido");
        assertThrows( NumeroDeContasChegouAoLimiteExcecao.class,() -> contaServico.criarContaDePessoa(payloadPF));
    }
}