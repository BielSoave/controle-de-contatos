package com.api.controle_de_contatos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "Controle de contatos api", version = "1",description = "Api desenvolvida para cadastro de usuários e de contatos"))
@SpringBootApplication
public class ControleDeContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeContatosApplication.class, args);
	}

}
