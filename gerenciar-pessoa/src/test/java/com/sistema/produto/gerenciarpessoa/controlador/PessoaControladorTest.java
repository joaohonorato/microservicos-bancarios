package com.sistema.produto.gerenciarpessoa.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.produto.gerenciarpessoa.dominio.PessoaPayload;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarpessoa.excecoes.ContaNaoCadastradaExcecao;
import com.sistema.produto.gerenciarpessoa.servico.PessoaServico;
import com.sistema.produto.gerenciarpessoa.util.i18n.Mensagens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
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
class PessoaControladorTest {
    private final static String URI_PESSOA = "/pessoa";
    private final static String URI_PESSOA_UM_SCORE = "/pessoa/1/score";

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PessoaServico pessoaServico;

    @MockBean
    private Mensagens mensagens;

    @InjectMocks
    private PessoaControlador pessoaControlador;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void salvarPessoaquandoPayloadValidoRetornaStatusCriadoComSucessoTrue() throws Exception, ContaNaoCadastradaExcecao {
        //Given
        PessoaPayload payload = new PessoaPayload("Pessoa Teste 1", TipoPessoa.PESSOA_FISICA);
        PessoaDTO resultado = new PessoaDTO(1L,"Pessoa Teste 1", TipoPessoa.PESSOA_FISICA, 6, true);
        given(pessoaServico.salvar(payload)).willReturn(resultado);
        given(mensagens.obterMensagem(Mockito.anyString())).willReturn("Pessoa criada com sucesso!");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI_PESSOA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isCreated())
                .andExpect(jsonPath("sucesso", is(true)));
    }

    @Test
    public void salvarPessoaquandoPayloadVazioRetornaStatusBadRequest() throws Exception, ContaNaoCadastradaExcecao {
        //Given
        PessoaPayload payload = new PessoaPayload();
        PessoaDTO resultado = new PessoaDTO(1L,"Pessoa Teste 1", TipoPessoa.PESSOA_FISICA, 6, true);
        given(pessoaServico.salvar(payload)).willReturn(resultado);
        given(mensagens.obterMensagem(Mockito.anyString())).willReturn("JSON mal formatado");

        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI_PESSOA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }
    @Test
    public void salvarPessoaquandoPayloadSemNomePessoaRetornaStatusBadRequest() throws Exception, ContaNaoCadastradaExcecao {
        //Given
        PessoaPayload payload = new PessoaPayload();
        PessoaDTO resultado = new PessoaDTO(1L,"Pessoa Teste 1", TipoPessoa.PESSOA_FISICA, 6, true);
        given(pessoaServico.salvar(payload)).willReturn(resultado);
        given(mensagens.obterMensagem(Mockito.anyString())).willReturn("JSON mal formatado");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI_PESSOA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }

    @Test
    public void salvarPessoaquandoPayloadComTipoPessoaInvalidoRetornaStatusBadRequest() throws Exception, ContaNaoCadastradaExcecao {
        //Given
        PessoaPayload payload = new PessoaPayload("Nome teste", null);
        PessoaDTO resultado = new PessoaDTO(1L,"Pessoa Teste 1", TipoPessoa.PESSOA_FISICA, 6, true);
        given(pessoaServico.salvar(payload)).willReturn(resultado);
        given(mensagens.obterMensagem(Mockito.anyString())).willReturn("JSON mal formatado");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URI_PESSOA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                // Expect
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("JSON mal formatado")));
    }

    @Test
    public void buscarScorePessoaquandoPayloadValidoRetornaStatusCriadoComSucessoTrue() throws Exception, ContaNaoCadastradaExcecao {
        //Given
        Long payload = 1L;
        Integer resultado = 6;
        given(pessoaServico.buscaScore(payload)).willReturn(resultado);
        given(mensagens.obterMensagem(Mockito.anyString())).willReturn("Score buscado com sucesso");
        //Then
        mockMvc.perform(
                MockMvcRequestBuilders.get(URI_PESSOA_UM_SCORE)
                        .contentType(MediaType.APPLICATION_JSON))
                // Expect
                .andExpect(status().isOk())
                .andExpect(jsonPath("sucesso", is(true)));
    }
}