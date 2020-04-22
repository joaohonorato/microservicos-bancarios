package com.sistema.produto.localizadorservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LocalizadorServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalizadorServicoApplication.class, args);
	}

}
