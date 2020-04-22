package com.sistema.produto.gerenciarconta;

import com.sistema.produto.gerenciarconta.controlador.ContaControlador;
import com.sistema.produto.gerenciarconta.dominio.fabrica.ContaFabrica;
import com.sistema.produto.gerenciarconta.servico.ContaServico;
import com.sistema.produto.gerenciarconta.servico.rest.ProdutoServico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GerenciarContaApplicationTests {

	@Autowired
	private ContaControlador contaControlador;

	@Autowired
	private ContaServico contaServico;

	@Autowired
	private ProdutoServico produtoServico;

	@Autowired
	private ContaFabrica contaFabrica;


	@Test
	void contextLoads() {
		assertThat(contaControlador).isNotNull();
		assertThat(contaServico).isNotNull();
		assertThat(produtoServico).isNotNull();
		assertThat(contaFabrica).isNotNull();
	}

}
