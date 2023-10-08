package com.br.fastBurguer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.br.fastBurguer.domain")
public class FastBurguerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastBurguerApplication.class, args);
	}
}
