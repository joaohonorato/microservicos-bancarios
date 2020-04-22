package com.sistema.produto.gerenciarproduto.controlador;

import com.sistema.produto.gerenciarproduto.dominio.ApiResposta;
import com.sistema.produto.gerenciarproduto.dominio.dto.ProdutoDTO;
import com.sistema.produto.gerenciarproduto.dominio.payload.ProdutoPayload;
import com.sistema.produto.gerenciarproduto.servico.ProdutoServico;
import com.sistema.produto.gerenciarproduto.util.i18n.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("produto")
public class ProdutoControlador {


    private ProdutoServico produtoServico;
    private Mensagens mensagens;

    public ProdutoControlador(ProdutoServico produtoServico, Mensagens mensagens) {
        this.produtoServico = produtoServico;
        this.mensagens = mensagens;
    }

    //
    @PostMapping
    public ResponseEntity<ApiResposta<ProdutoDTO>> criarProdutos(@RequestBody ProdutoPayload payload) {
        ProdutoDTO produtoDTO = produtoServico.criarProdutos(payload);
        String mensagem;
        if(produtoDTO.getCartaoCredito() == null) {
            mensagem = mensagens.obterMensagem("cheque.desabilitado.cartaoCredito.nao.gerado");
        } else {
            mensagem = mensagens.obterMensagem("cheque.com.limite.cartao.com.limite", produtoDTO.getChequeEspecial().getLimite(),produtoDTO.getCartaoCredito().getLimite());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResposta<>(true, mensagem, produtoDTO));
    }
}
