package com.sistema.produto.gerenciarconta.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.produto.gerenciarconta.dominio.dtos.ContaDTO;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarconta.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarconta.excecoes.NumeroDeContasChegouAoLimiteExcecao;
import com.sistema.produto.gerenciarconta.servico.ContaServico;
import com.sistema.produto.gerenciarconta.util.i18n.Mensagens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest
class ContaControladorTest {
    private final static String URI = "/conta";

    @Value("${app.agencia}")
    private String agencia;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ContaServico contaServico;

    @InjectMocks
    private ContaControlador contaControlador;

    @MockBean
    private Mensagens mensagens;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void quandoPayloadValidoRetornaStatusCriadoComSucessoTrue() throws Exception, NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payload = new ContaPayload(1L, TipoPessoa.PESSOA_FISICA);
        ContaDTO resposta = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        given(contaServico.criarContaDePessoa(payload)).willReturn(resposta);
        given(mensagens.obterMensagem(Mockito.any())).willReturn("Conta criada com sucesso");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(payload)))
        // Expect
                .andExpect(status().isCreated())
                .andExpect(jsonPath("sucesso", is(true)));
    }

    @Test
    public void quandoPayloadVazioRetornaStatusBadRequest() throws Exception, NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payload = new ContaPayload();
        ContaDTO resposta = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        given(contaServico.criarContaDePessoa(payload)).willReturn(resposta);
        given(mensagens.obterMensagem(Mockito.any())).willReturn("JSON mal formatado");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }
    @Test
    public void quandoPayloadSemPessoaIdRetornaStatusBadRequest() throws Exception, NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payload = new ContaPayload();
        payload.setTipoPessoa(TipoPessoa.PESSOA_FISICA);
        ContaDTO resposta = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        given(contaServico.criarContaDePessoa(payload)).willReturn(resposta);
        given(mensagens.obterMensagem(Mockito.any())).willReturn("JSON mal formatado");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }

    @Test
    public void quandoPayloadComTipoPessoaInvalidoRetornaStatusBadRequest() throws Exception, NumeroDeContasChegouAoLimiteExcecao {
        //Given
        ContaPayload payload = new ContaPayload(1L, null);
        ContaDTO resposta = new ContaDTO("000001",agencia, TipoConta.CONTA_CORRENTE, 1L, true);
        given(contaServico.criarContaDePessoa(payload)).willReturn(resposta);
        given(mensagens.obterMensagem(Mockito.any())).willReturn("JSON mal formatado");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }
}