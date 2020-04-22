package com.sistema.produto.gerenciarpessoa.controlador;

import com.sistema.produto.gerenciarpessoa.dominio.ApiResposta;
import com.sistema.produto.gerenciarpessoa.dominio.PessoaPayload;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import com.sistema.produto.gerenciarpessoa.excecoes.ContaNaoCadastradaExcecao;
import com.sistema.produto.gerenciarpessoa.excecoes.EntidadeNaoEncontradaExcecao;
import com.sistema.produto.gerenciarpessoa.servico.PessoaServico;
import com.sistema.produto.gerenciarpessoa.util.i18n.Mensagens;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaControlador {

    private PessoaServico pessoaServico;
    private Mensagens mensangens;

    public PessoaControlador(PessoaServico pessoaServico, Mensagens mensangens) {
        this.pessoaServico = pessoaServico;
        this.mensangens = mensangens;
    }

    @PostMapping
    public ResponseEntity<ApiResposta<PessoaDTO>> criarPessoa(@Valid @RequestBody PessoaPayload payload) throws ContaNaoCadastradaExcecao {
        PessoaDTO pessoaDTO = pessoaServico.salvar(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResposta<PessoaDTO>(true,mensangens.obterMensagem("pessoa.criada.sucesso"), pessoaDTO));
    }

    @GetMapping("/{pessoaId}/score")
    public ResponseEntity<ApiResposta<Integer>> buscaScore(@PathVariable("pessoaId") Long pessoaId) throws EntidadeNaoEncontradaExcecao {
        Integer score = pessoaServico.buscaScore(pessoaId);
        if(score ==null) {
            ResponseEntity.ok(new ApiResposta<Integer>(false, mensangens.obterMensagem("score.obtido.falha", pessoaId)));
        }
        return ResponseEntity.ok(new ApiResposta<Integer>(true, mensangens.obterMensagem("score.obtido.sucesso"), score));
    }
}
