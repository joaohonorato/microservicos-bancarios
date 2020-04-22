package com.sistema.produto.gerenciarproduto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class GerenciarProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarProdutoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8)).build();
	}
}
