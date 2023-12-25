package com.br.fastBurguer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.br.fastBurguer.infra.persistence.client", "com.br.fastBurguer.infra.persistence.cpf, com.br.fastBurguer.infra.persistence.email"
, "com.br.fastBurguer.infra.persistence.order", "com.br.fastBurguer.infra.persistence.products", "com.br.fastBurguer.infra.persistence.queue"})
public class FastBurguerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastBurguerApplication.class, args);
	}
}
