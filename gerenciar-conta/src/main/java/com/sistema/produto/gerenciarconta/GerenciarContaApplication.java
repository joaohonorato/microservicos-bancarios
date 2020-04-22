package com.sistema.produto.gerenciarconta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@SpringBootApplication
@EnableEurekaClient
public class GerenciarContaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarContaApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		builder.setConnectTimeout(Duration.ofSeconds(5L));
		return builder.additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8)).build();
	}
}
